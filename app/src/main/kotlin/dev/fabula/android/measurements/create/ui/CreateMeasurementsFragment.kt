package dev.fabula.android.measurements.create.ui

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.*
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.location.Location
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.fabula.android.BuildConfig
import dev.fabula.android.R
import dev.fabula.android.app.ui.*
import dev.fabula.android.app.util.Util
import dev.fabula.android.app.util.Util.Companion.cutMeasurement
import dev.fabula.android.bluetooth.GLMDeviceController.*
import dev.fabula.android.camera.CameraViewModel
import dev.fabula.android.databinding.CreateMeasurementsFragmentBinding
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.dimensions.fence.model.DimensionsFenceTransit
import dev.fabula.android.measurements.create.adapter.CreateMeasurementsListAdapter
import dev.fabula.android.measurements.create.di.CreateMeasurementsComponent
import dev.fabula.android.measurements.model.MeasureCalc
import dev.fabula.android.measurements.model.Measurement
import dev.fabula.android.measurements.receiver.MeasurementReceiver
import kotlinx.android.synthetic.main._canopy_fragment.view.*
import kotlinx.android.synthetic.main.create_measurements_fragment.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import java.lang.Math.cos
import java.util.*
import kotlin.math.*

class CreateMeasurementsFragment :
    ViewModelFragment<CreateMeasurementsFragmentBinding>(R.layout.create_measurements_fragment) {

    private lateinit var myView: View

    private var CALIBRATION_FLAG = false
    private var L1 = 0.0
    private var L2 = 0.0

    private var L0 = 0.0
    private var dh = 0.0
    private var a1 = 0.0
    private var a2 = 0.0
    private var isACTIVE = true

    private val viewModel: CreateMeasurementsViewModel by activityViewModel()
    private val viewModelCamera: CameraViewModel by activityViewModel()

    private val uidPlatform get() = arguments?.getString("uid_platform")
    private val uidCanopy get() = arguments?.getString("uid_canopy")
    private val uidContactWire get() = arguments?.getString("uid_contact_wire")
    private val uidCarrierWire get() = arguments?.getString("uid_carrier_wire")
    private val uidMeasurementType get() = arguments?.getString("uid_measurement_type")

    private val dimensionsFencesTransitJson get() = arguments?.getString("dimension_fences_json_data")

    private var dimensionsFencesTransit: DimensionsFenceTransit? = null

    private val uidBridge get() = arguments?.getString("uid_bridge")

    private val uid get() = arguments?.getString("uid")
    private var alertDialogCalib: AlertDialog? = null

    private var imageCommentBitmap: Bitmap? = null
    private var uidMeasurement: String? = null
    private var _flag_created: Boolean? = null

    private lateinit var measurementReceiver: MeasurementReceiver

    private lateinit var adapter: CreateMeasurementsListAdapter

    private var measurements: MutableList<MeasureCalc> = mutableListOf()

    private val REQUEST_PERMISSIONS_REQUEST_CODE = 34
    private var mCurrentLocation: Location? = null

    private val mFusedLocationClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(
            requireContext()
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        CreateMeasurementsComponent.create(context).inject(this)
    }

    override fun onDetach() {
        super.onDetach()
        measurementReceiver.destroyReceiver()
    }

    private fun dialogNorms() {
        val view: View = layoutInflater.inflate(R.layout.dialog_height_width_norms, null)
        val alertDialog = AlertDialog.Builder(requireContext()).create()
        alertDialog.setTitle(resources.getString(R.string.norms))
        alertDialog.setCancelable(false)
        alertDialog.setView(view)

        val _width = view.findViewById<View>(R.id.width) as TextView
        val _height = view.findViewById<View>(R.id.height) as TextView

        _width.text = Util.WIDTH_NORM.toString()
        _height.text = Util.HEIGHT_NORM.toString()

        alertDialog.setButton(
            AlertDialog.BUTTON_POSITIVE,
            resources.getString(R.string.save)
        ) { _, _ ->
            Util.WIDTH_NORM = _width.text.toString().toInt()
            Util.HEIGHT_NORM = _height.text.toString().toInt()
        }

        alertDialog.setButton(
            AlertDialog.BUTTON_NEGATIVE,
            resources.getString(R.string.action_close)
        ) { _, _ ->

        }

        alertDialog.show()
    }

    @SuppressLint("CutPasteId")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestLastLocation(true)

        dimensionsFencesTransitJson?.let { json ->
            dimensionsFencesTransit =
                Gson().fromJson(json, object : TypeToken<DimensionsFenceTransit?>() {}.type)

            if (dimensionsFencesTransit!!.listDf.isEmpty()) {
                createDirectionDimensionsFences()
            }
        }

        CALIBRATION_FLAG = false
        myView = view
        dialogNorms()
        adapter = CreateMeasurementsListAdapter()

        adapter.onItemClick = { boschMeasurement ->
            showTmpMeasurement(boschMeasurement.info)
        }

        alertDialogCalib = AlertDialog.Builder(requireContext()).create()

        measurementReceiver = MeasurementReceiver(requireContext(), ACTION_SYNC_CONTAINER_RECEIVED)
        measurementReceiver.initializeReceiver()

        measurementReceiver.boschMeasurement.event(viewLifecycleOwner) { boschMeasure ->

            if (!isACTIVE)
                return@event

            if (CALIBRATION_FLAG) {

                boschMeasure.gipotinuza *= 1000.0
                L1 = boschMeasure.gipotinuza
                a1 = boschMeasure.ugol

                L0 = ((L1 + 760) / 2)

                dh = abs(2 * L0 * sin(Math.toRadians(a1)))

                CALIBRATION_FLAG = false

                Toast.makeText(requireContext(), "Устройство откалибровано", Toast.LENGTH_SHORT)
                    .show()

                alertDialogCalib?.hide()

                if (measurements.size > 0) {
                    measurements.forEach { measure ->

                        val littleMeasurement = measurementReceiver.calculateMeasure(
                            L0,
                            L1,
                            measure.L2,
                            a1,
                            measure.a2,
                            requireContext(),
                            dh
                        )
                        measure.info = littleMeasurement.info

                        uidPlatform?.let {
                            measure.length = cutMeasurement(littleMeasurement.L.toString())
                            measure.height = cutMeasurement(littleMeasurement.Hvn.toString())
                            measure.isMeasureOverNormal =
                                littleMeasurement.L < Util.WIDTH_NORM || littleMeasurement.Hvn < Util.HEIGHT_NORM
                        }

                        uidCanopy?.let {
                            measure.length = cutMeasurement(littleMeasurement.L.toString())
                            measure.height = cutMeasurement(littleMeasurement.Hvn.toString())
                            measure.isMeasureOverNormal =
                                littleMeasurement.L < Util.WIDTH_NORM || littleMeasurement.Hvn < Util.HEIGHT_NORM
                        }

                        dimensionsFencesTransit?.let {
                            measure.length = cutMeasurement(littleMeasurement.L.toString())
                            measure.height = cutMeasurement(littleMeasurement.Hvn.toString())
                            measure.isMeasureOverNormal =
                                littleMeasurement.L < Util.WIDTH_NORM || littleMeasurement.Hvn < Util.HEIGHT_NORM
                        }

                        uidContactWire?.let {
                            measure.length = "0.0"
                            measure.height = cutMeasurement(littleMeasurement.Hmin.toString())
                            measure.isMeasureOverNormal =
                                littleMeasurement.Hmin < Util.HEIGHT_NORM
                        }

                        uidCarrierWire?.let {
                            measure.length = "0.0"
                            measure.height = cutMeasurement(littleMeasurement.Hmin.toString())
                            measure.isMeasureOverNormal =
                                littleMeasurement.Hmin < Util.HEIGHT_NORM
                        }

                        uidBridge?.let {
                            measure.length = cutMeasurement(littleMeasurement.L.toString())
                            measure.height = "0.0"
                            measure.isMeasureOverNormal = littleMeasurement.L < Util.WIDTH_NORM
                        }
                    }

                    adapter.submitList(measurements)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(
                        requireContext(),
                        "Результаты измерений перерасчитаны",
                        Toast.LENGTH_LONG
                    ).show()
                }

            } else {

                boschMeasure.gipotinuza *= 1000.0
                L2 = boschMeasure.gipotinuza
                a2 = boschMeasure.ugol

                val littleMeasurement =
                    measurementReceiver.calculateMeasure(L0, L1, L2, a1, a2, requireContext(), dh)
                val L = littleMeasurement.L
                val Hvn = littleMeasurement.Hvn
                val Hmin = littleMeasurement.Hmin
                val info = littleMeasurement.info

                uidPlatform?.let {
                    checkMeasurement(L, true, Hvn, true, L2, a2, null, info, null, false)
                }
                uidCanopy?.let {
                    checkMeasurement(L, true, Hvn, true, L2, a2, null, info, null, false)
                }

                //delete?
                dimensionsFencesTransit?.let {
                    checkMeasurement(
                        L,
                        true,
                        Hvn,
                        true,
                        L2,
                        a2,
                        dimensionsFencesTransit!!.countDf,
                        info,
                        "", true
                    )
                }

                uidContactWire?.let {
                    checkMeasurement(0.0, false, Hmin, true, L2, a2, 1, info, null, false)
                }

                uidCarrierWire?.let {
                    checkMeasurement(0.0, false, Hmin, true, L2, a2, 1, info, null, false)
                }

                uidBridge?.let {
                    checkMeasurement(L, true, 0.0, false, L2, a2, null, info, null, false)
                }
            }

        }


//        val filter = IntentFilter(ACTION_SYNC_CONTAINER_RECEIVED)
//
//        receiver = object : BroadcastReceiver() {
//            override fun onReceive(context: Context?, intent: Intent) {
//
//                var prevResult = Float.MIN_VALUE.toDouble()
//                val result = intent.extras!!.getFloat(EXTRA_MEASUREMENT).toDouble()
//                val devMode = intent.extras!!.getInt(EXTRA_MEASUREMENT_TYPE).toDouble()
//                var gipotinuza = intent.extras!!.getFloat(EXTRA_MEASUREMENT_COMP1).toDouble()
//                val ugol = intent.extras!!.getFloat(EXTRA_MEASUREMENT_COMP2).toDouble()
//
//                Log.e("BroadcastReceiver2", "$result / $gipotinuza / $ugol / $devMode")
//
//                if (prevResult != gipotinuza) {
//                    prevResult = gipotinuza
//                } else {
//                    return
//                }
//
//                if (!isACTIVE)
//                    return
//
//                if (CALIBRATION_FLAG) {
//
//                    gipotinuza *= 1000.0
//                    L1 = gipotinuza
//                    a1 = ugol
//
//                    L0 = ((L1 + 760) / 2).toDouble()
//
//                    dh = abs(2 * L0 * sin(Math.toRadians(a1)))
//
//                    CALIBRATION_FLAG = false
//
//
//                    Toast.makeText(requireContext(), "Устройство откалибровано", Toast.LENGTH_SHORT)
//                        .show()
//
//                    alertDialogCalib?.hide()
//
//                    if (measurements.size > 0) {
//                        measurements.forEach { measure ->
//
//                            val littleMeasurement = calculateMeasure(measure.L2, measure.a2)
//                            measure.info = littleMeasurement.info
//
//                            uidPlatform?.let {
//                                measure.length = cutMeasurement(littleMeasurement.L.toString())
//                                measure.height = cutMeasurement(littleMeasurement.Hvn.toString())
//                                measure.isMeasureOverNormal =
//                                    littleMeasurement.L < Util.WIDTH_NORM || littleMeasurement.Hvn < Util.HEIGHT_NORM
//                            }
//
//                            uidCanopy?.let {
//                                measure.length = cutMeasurement(littleMeasurement.L.toString())
//                                measure.height = cutMeasurement(littleMeasurement.Hvn.toString())
//                                measure.isMeasureOverNormal =
//                                    littleMeasurement.L < Util.WIDTH_NORM || littleMeasurement.Hvn < Util.HEIGHT_NORM
//                            }
//
//                            dimensionsFencesTransit?.let {
//                                measure.length = cutMeasurement(littleMeasurement.L.toString())
//                                measure.height = cutMeasurement(littleMeasurement.Hvn.toString())
//                                measure.isMeasureOverNormal =
//                                    littleMeasurement.L < Util.WIDTH_NORM || littleMeasurement.Hvn < Util.HEIGHT_NORM
//                            }
//
//                            uidContactWire?.let {
//                                measure.length = "0.0"
//                                measure.height = cutMeasurement(littleMeasurement.Hmin.toString())
//                                measure.isMeasureOverNormal =
//                                    littleMeasurement.Hmin < Util.HEIGHT_NORM
//                            }
//
//                            uidCarrierWire?.let {
//                                measure.length = "0.0"
//                                measure.height = cutMeasurement(littleMeasurement.Hmin.toString())
//                                measure.isMeasureOverNormal =
//                                    littleMeasurement.Hmin < Util.HEIGHT_NORM
//                            }
//
//                            uidBridge?.let {
//                                measure.length = cutMeasurement(littleMeasurement.L.toString())
//                                measure.height = "0.0"
//                                measure.isMeasureOverNormal = littleMeasurement.L < Util.WIDTH_NORM
//                            }
//                        }
//
//                        adapter.submitList(measurements)
//                        adapter.notifyDataSetChanged()
//                        Toast.makeText(
//                            requireContext(),
//                            "Результаты измерений перерасчитаны",
//                            Toast.LENGTH_LONG
//                        ).show()
//                    }
//
//                } else {
//
//                    gipotinuza *= 1000.0
//                    L2 = gipotinuza
//                    a2 = ugol
//
//                    val littleMeasurement = calculateMeasure(L2, a2)
//                    val L = littleMeasurement.L
//                    val Hvn = littleMeasurement.Hvn
//                    val Hmin = littleMeasurement.Hmin
//                    val info = littleMeasurement.info
//
//                    uidPlatform?.let {
//                        checkMeasurement(L, true, Hvn, true, L2, a2, null, info, null, false)
//                    }
//                    uidCanopy?.let {
//                        checkMeasurement(L, true, Hvn, true, L2, a2, null, info, null, false)
//                    }
//
//                    //delete?
//                    dimensionsFencesTransit?.let {
//                        checkMeasurement(
//                            L,
//                            true,
//                            Hvn,
//                            true,
//                            L2,
//                            a2,
//                            dimensionsFencesTransit!!.countDf,
//                            info,
//                            "", true
//                        )
//                    }
//
//                    uidContactWire?.let {
//                        checkMeasurement(0.0, false, Hmin, true, L2, a2, 1, info, null, false)
//                    }
//
//                    uidCarrierWire?.let {
//                        checkMeasurement(0.0, false, Hmin, true, L2, a2, 1, info, null, false)
//                    }
//
//                    uidBridge?.let {
//                        checkMeasurement(L, true, 0.0, false, L2, a2, null, info, null, false)
//                    }
//                }
//            }
//        }
//        requireContext().registerReceiver(receiver, filter)

        binding = CreateMeasurementsFragmentBinding.bind(view).apply {

            recyclerView.adapter = adapter

            uid?.let { uid ->
                viewModel.getMeasurementById(uid)
            }

            viewModel.measurement.event(viewLifecycleOwner) {
                try {
                    numberPath.setText(it.way_number)
                    uidMeasurement = it.uid
                    kmPath.setText(it.km_way.toString())
                    piket.setText(it.picket.toString())
                    length.setText(it.horizontal_gabarit)
                    height.setText(it.vertical_gabarit)
                    comment.setText(it.comment)

                    _flag_created = it.flag_created


                    it.photo2?.let { photo2 ->
                        imageComment.setImageBitmap(viewModelCamera.convertImage(photo2))
                    }

                } catch (e: Exception) {
                    Timber.e("CreateMeasurementsFragmentBinding ${e.message}")
                }
            }

            btnCalibration.setOnClickListener {
                val _view: View = layoutInflater.inflate(R.layout.calibration_dialog, null)
                val alertDialog = AlertDialog.Builder(requireContext()).create()
                alertDialog.setTitle(resources.getString(R.string.calibration_values))
                alertDialog.setCancelable(false)
                alertDialog.setView(_view)

                val _width = _view.findViewById<View>(R.id.length) as TextView
                val _height = _view.findViewById<View>(R.id.height) as TextView
                val _angle = _view.findViewById<View>(R.id.angle) as TextView

                _width.text = L0.toString()
                _height.text = dh.toString()
                _angle.text = a1.toString()


                alertDialog.setButton(
                    AlertDialog.BUTTON_POSITIVE,
                    resources.getString(R.string.action_close)
                ) { _, _ ->

                }

                alertDialog.setButton(
                    AlertDialog.BUTTON_NEGATIVE,
                    resources.getString(R.string.make_calibration)
                ) { _, _ ->
                    waitCalibrationMeasurement()
                }

                alertDialog.show()
            }

            btnNorms.setOnClickListener {
                dialogNorms()
            }

            btnComment.setOnClickListener {
                card_image_comment.visibility =
                    if (card_image_comment.visibility == View.GONE) View.VISIBLE else View.GONE
                comment_container.visibility =
                    if (comment_container.visibility == View.GONE) View.VISIBLE else View.GONE
            }

            imageComment.setOnClickListener {
                viewModelCamera.actionPhoto.postValue(Event(true))
            }

            viewModelCamera.takePhotoAction.event(viewLifecycleOwner) { bitmap ->
                bitmap.let {
                    imageCommentBitmap = bitmap
                    viewModelCamera.insertBitmapOnImageView(requireContext(), bitmap, imageComment)
                }
            }

            viewModel.measurementInsert.event(viewLifecycleOwner) {
                it.let {
                    if (it) {
                        showMessage(R.string.data_added_success)
                        findNavController().navigateUp()
                    } else {
                        showMessage(R.string.data_added_error)
                    }
                }
            }

            btnSave.setOnClickListener { view -> save(view) }

            LayoutHeaderViewHolder(layoutHeader, requireContext()).apply {
                onItemClickImage = {
                    findNavController().navigate(R.id.action_create_measurements_to_profile)
                }
                onItemClickButtonBack = {
                    findNavController().navigateUp()
                }
            }.bind(R.string.crete_measurement)
        }
    }


    private fun checkMeasurement(
        L: Double,
        isCheckL: Boolean,
        H: Double,
        isCheckH: Boolean,
        L2: Double,
        a2: Double,
        countPublicMeasure: Int?,
        info: String,
        whichDirection: String?,
        isDimensionFence: Boolean
    ) {

        if (countPublicMeasure != null) {
            if (measurements.size >= countPublicMeasure) {
                Toast.makeText(requireContext(), "Все измерения уже сделаны", Toast.LENGTH_SHORT)
                    .show()
                return
            }
        }

        if (isDimensionFence && whichDirection?.isEmpty() == true) {
            dialogWhichDirection(L, isCheckL, H, isCheckH, L2, a2, countPublicMeasure, info)
            return
        }

        if (isCheckL && isCheckH) {
            if (L < Util.WIDTH_NORM || H < Util.HEIGHT_NORM) {
                isACTIVE = false
                dialogMeasureOverNorm(L, H, L2, a2, info, whichDirection)

            } else {
                addMeasure(L, H, L2, a2, info, false, whichDirection)
            }

        } else if (isCheckL && !isCheckH) {

            if (L < Util.WIDTH_NORM) {
                isACTIVE = false
                dialogMeasureOverNorm(L, H, L2, a2, info, whichDirection)

            } else {
                addMeasure(L, H, L2, a2, info, false, whichDirection)
            }

        } else if (!isCheckL && isCheckH) {

            if (H < Util.HEIGHT_NORM) {
                isACTIVE = false
                dialogMeasureOverNorm(L, H, L2, a2, info, whichDirection)

            } else {
                addMeasure(L, H, L2, a2, info, false, whichDirection)
            }
        }
    }

    private fun addMeasure(
        L: Double,
        H: Double,
        L2: Double,
        a2: Double,
        info: String,
        isMeasureOverNormal: Boolean,
        whichDirection: String?
    ) {
        addMeasurementToList(
            MeasureCalc(
                cutMeasurement(L.toString()),
                cutMeasurement(H.toString()),
                L2,
                a2,
                "0.0",
                "0.0",
                info,
                isMeasureOverNormal,
                whichDirection
            )
        )
    }

    private fun dialogMeasureOverNorm(
        L: Double, H: Double, L2: Double, a2: Double, info: String, whichDirection: String?
    ) {
        val dialog = AlertDialog.Builder(myView.context).create()
        dialog.setTitle(resources.getString(R.string.value_measurement_less_norms))
        dialog.setCancelable(false)

        dialog.setButton(
            AlertDialog.BUTTON_NEGATIVE,
            resources.getString(R.string.re_measure)
        ) { _, _ ->
            isACTIVE = true
        }
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, resources.getString(R.string.save)) { _, _ ->
            isACTIVE = true
            addMeasure(L, H, L2, a2, info, true, whichDirection)
        }

        dialog.show()
    }

    private fun waitCalibrationMeasurement() {
        CALIBRATION_FLAG = true
        alertDialogCalib!!.setTitle(resources.getString(R.string.calibration))
        alertDialogCalib!!.setCancelable(false)
        alertDialogCalib!!.setMessage(resources.getString(R.string.take_measurement))
        alertDialogCalib!!.setButton(
            AlertDialog.BUTTON_POSITIVE,
            resources.getString(R.string.action_cancel)
        ) { _, _ -> CALIBRATION_FLAG = false }

        alertDialogCalib!!.show()
    }

    private fun showTmpMeasurement(strMeasurement: String) {
        val dialog = AlertDialog.Builder(requireContext()).create()
        dialog.setTitle(resources.getString(R.string.measurement_details))
        dialog.setCancelable(false)
        dialog.setMessage(strMeasurement)
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ок") { _, _ -> }
        dialog.show()
    }


    private fun addMeasurementToList(
        measure: MeasureCalc
    ) {
        measurements.add(measure)

        adapter.submitList(measurements)
        adapter.notifyDataSetChanged()
    }


    @SuppressLint("LogNotTimber")
    private fun save(view: View) {
        binding?.apply {
            if (
                numberPath.text.isNullOrEmpty() ||
                kmPath.text.isNullOrEmpty() ||
                piket.text.isNullOrEmpty()
            ) {
                showMessage(R.string.fill_in_all_fields)
                return
            }

            if (measurements.isNullOrEmpty()) {
                showMessage(R.string.need_create_measurement)
                return
            }

            Timber.i("Create measurements: platform=$uidPlatform \n canopy=$uidCanopy \n contactWire=$uidContactWire \n carrierWire=$uidCarrierWire")

            var flag_edited: Boolean? = null
            var flag_created: Boolean? = null
            if (uidMeasurement == null) {
                uidMeasurement = UUID.randomUUID().toString()
                flag_created = true
            } else {
                flag_edited = true
                flag_created = _flag_created
            }

            val commetPhoto = viewModelCamera.convertImage(imageComment)

            uidPlatform?.let { platform ->
                Timber.i("Try send measurement to server uidPlatform")

                val list: MutableList<Measurement> = mutableListOf()
                measurements.forEach { bmc ->
                    list.add(
                        Measurement(
                            UUID.randomUUID().toString(),
                            bmc.gipotinuza,
                            bmc.ugol,
                            bmc.height,
                            bmc.length,
                            mCurrentLocation?.latitude.toString(),
                            mCurrentLocation?.longitude.toString(),
                            kmPath.text.toString().toDouble(),
                            numberPath.text.toString(),
                            piket.text?.toString(),
                            0,
                            0,
                            comment.text.toString(),
                            null,
                            commetPhoto,
                            platform,
                            null,
                            null,
                            null,
                            null,
                            null,
                            uidMeasurementType,
                            flag_created,
                            flag_edited,
                            getCurrentDateTimeStamp()
                        )
                    )
                }

                viewModel.create(list)
            }

            uidCanopy?.let { canopy ->
                Timber.i("Try send measurement to server uidCanopy")

                val list: MutableList<Measurement> = mutableListOf()
                measurements.forEach { bmc ->
                    list.add(
                        Measurement(
                            UUID.randomUUID().toString(),
                            bmc.gipotinuza,
                            bmc.ugol,
                            bmc.height,
                            bmc.length,
                            mCurrentLocation?.latitude.toString(),
                            mCurrentLocation?.longitude.toString(),
                            kmPath.text.toString().toDouble(),
                            numberPath.text.toString(),
                            piket.text?.toString(),
                            0,
                            0,
                            comment.text.toString(),
                            null,
                            commetPhoto,
                            null,
                            canopy,
                            null,
                            null,
                            null,
                            null,
                            uidMeasurementType,
                            flag_created,
                            flag_edited,
                            getCurrentDateTimeStamp()
                        )

                    )
                }

                Timber.i("uidCanopy create list measurement: ${list.size}")
                viewModel.create(list)
            }

            dimensionsFencesTransit?.let { listDimens ->
                Timber.i("Try send measurement to server stationDimension")

                var dimensionsFenceUid: String? = null


                val list: MutableList<Measurement> = mutableListOf()

                measurements.forEach { measure ->

                    listDimens.listDf.forEach {
                        if (it.direction == measure.whichDirection) dimensionsFenceUid = it.uid
                    }
                    if (dimensionsFenceUid == null) Toast.makeText(
                        requireContext(),
                        "ERROR!!!",
                        Toast.LENGTH_SHORT
                    ).show()

                    list.add(
                        Measurement(
                            UUID.randomUUID().toString(),
                            measure.gipotinuza,
                            measure.ugol,
                            measure.length,
                            measure.height,
                            mCurrentLocation?.latitude.toString(),
                            mCurrentLocation?.longitude.toString(),
                            kmPath.text.toString().toDouble(),
                            numberPath.text.toString(),
                            piket.text?.toString(),
                            0,
                            0,
                            comment.text.toString(),
                            null,
                            viewModelCamera.convertImage(imageCommentBitmap),
                            null,
                            null,
                            dimensionsFenceUid,
                            null,
                            null,
                            null,
                            uidMeasurementType,
                            flag_created,
                            flag_edited,
                            getCurrentDateTimeStamp()
                        )
                    )

                    viewModel.create(list)
                }
            }

            uidContactWire?.let { contactWire ->
                Timber.i("Try send measurement to server -> uidContactWire")

                viewModel.create(
                    Measurement(
                        uidMeasurement!!,
                        measurements[0].gipotinuza,
                        measurements[0].ugol,
                        measurements[0].length,
                        measurements[0].height,
                        mCurrentLocation?.latitude.toString(),
                        mCurrentLocation?.longitude.toString(),
                        kmPath.text.toString().toDouble(),
                        numberPath.text.toString(),
                        piket.text?.toString(),
                        0,
                        0,
                        comment.text.toString(),
                        null,
                        viewModelCamera.convertImage(imageCommentBitmap),
                        null,
                        null,
                        null,
                        null,
                        contactWire,
                        null,
                        uidMeasurementType,
                        flag_created,
                        flag_edited,
                        getCurrentDateTimeStamp()
                    )
                )
            }

            uidCarrierWire?.let { carrierWire ->
                Timber.i("Try send measurement to server -> uidCarrierWire")
                viewModel.create(
                    Measurement(
                        uidMeasurement!!,
                        measurements[0].gipotinuza,
                        measurements[0].ugol,
                        measurements[0].length,
                        measurements[0].height,
                        mCurrentLocation?.latitude.toString(),
                        mCurrentLocation?.longitude.toString(),
                        kmPath.text.toString().toDouble(),
                        numberPath.text.toString(),
                        piket.text?.toString(),
                        0,
                        0,
                        comment.text.toString(),
                        null,
                        viewModelCamera.convertImage(imageCommentBitmap),
                        null,
                        null,
                        null,
                        carrierWire,
                        null,
                        null,
                        uidMeasurementType,
                        flag_created,
                        flag_edited,
                        getCurrentDateTimeStamp()
                    )
                )
            }

            uidBridge?.let { bridge ->
                Timber.i("Try send measurement to server -> uidBridge")
                val list: MutableList<Measurement> = mutableListOf()
                measurements.forEach { bmc ->
                    viewModel.create(
                        Measurement(
                            UUID.randomUUID().toString(),
                            bmc.gipotinuza,
                            bmc.ugol,
                            bmc.height,
                            bmc.length,
                            mCurrentLocation?.latitude.toString(),
                            mCurrentLocation?.longitude.toString(),
                            kmPath.text.toString().toDouble(),
                            numberPath.text.toString(),
                            piket.text?.toString(),
                            0,
                            0,
                            comment.text.toString(),
                            null,
                            viewModelCamera.convertImage(imageCommentBitmap),
                            null,
                            null,
                            null,
                            null,
                            null,
                            bridge,
                            uidMeasurementType,
                            flag_created,
                            flag_edited,
                            getCurrentDateTimeStamp()
                        )
                    )
                }
            }
        }
    }

    private fun buttonSetting(btn: Button, direction: String, visibility: Int) {
        btn.text = direction
        btn.visibility = visibility
    }

    @SuppressLint("CutPasteId")
    private fun createDirectionDimensionsFences() {
        val view: View = layoutInflater.inflate(R.layout.create_direction_dimensions_fences, null)
        val alertDialog = AlertDialog.Builder(requireContext())
            .setTitle(resources.getString(R.string.create_direction))
            .setCancelable(false)
            .setView(view)
            .setPositiveButton(android.R.string.ok, null)
            .create()

        val tf1 = view.findViewById<TextInputLayout>(R.id.direction_1)
        val tf2 = view.findViewById<TextInputLayout>(R.id.direction_2)
        val tf3 = view.findViewById<TextInputLayout>(R.id.direction_3)
        val tf4 = view.findViewById<TextInputLayout>(R.id.direction_4)

        if (dimensionsFencesTransit!!.countDf == 2) {
            tf3.visibility = View.GONE
            tf4.visibility = View.GONE
        }

        val uidPlatform = dimensionsFencesTransit!!.parentPlatformUid
        alertDialog.setOnShowListener {
            val button: Button = (alertDialog as AlertDialog).getButton(AlertDialog.BUTTON_POSITIVE)
            button.setOnClickListener {
                if (dimensionsFencesTransit!!.countDf == 2) {
                    if (checkDirections(listOf(tf1, tf2))) {
                        Toast.makeText(
                            requireContext(),
                            resources.getString(R.string.fill_in_all_fields),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {

                        dimensionsFencesTransit!!.listDf =
                            listOf(
                                DimensionsFence(
                                    UUID.randomUUID().toString(),
                                    uidPlatform,
                                    tf1.editText!!.text.toString(),
                                    flag_created = true,
                                    flag_edited = false
                                ), DimensionsFence(
                                    UUID.randomUUID().toString(),
                                    uidPlatform,
                                    tf2.editText!!.text.toString(),
                                    flag_created = true,
                                    flag_edited = false
                                )
                            )
                        viewModel.createDimensionFences(dimensionsFencesTransit!!.listDf)

                        alertDialog.dismiss()
                    }
                } else {
                    if (checkDirections(listOf(tf1, tf2, tf3, tf4))) {
                        Toast.makeText(
                            requireContext(),
                            resources.getString(R.string.fill_in_all_fields),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        dimensionsFencesTransit!!.listDf =
                            listOf(
                                DimensionsFence(
                                    UUID.randomUUID().toString(),
                                    uidPlatform,
                                    tf1.editText!!.text.toString(),
                                    flag_created = true,
                                    flag_edited = false
                                ), DimensionsFence(
                                    UUID.randomUUID().toString(),
                                    uidPlatform,
                                    tf2.editText!!.text.toString(),
                                    flag_created = true,
                                    flag_edited = false
                                ), DimensionsFence(
                                    UUID.randomUUID().toString(),
                                    uidPlatform,
                                    tf3.editText!!.text.toString(),
                                    flag_created = true,
                                    flag_edited = false
                                ), DimensionsFence(
                                    UUID.randomUUID().toString(),
                                    uidPlatform,
                                    tf4.editText!!.text.toString(),
                                    flag_created = true,
                                    flag_edited = false
                                )
                            )
                        alertDialog.dismiss()

                        viewModel.createDimensionFences(dimensionsFencesTransit!!.listDf)
                    }
                }
            }
        }


        alertDialog.show()
    }

    private fun checkDirections(inputLayout: List<TextInputLayout>): Boolean {
        var flag = false
        inputLayout.forEach {
            if (it.editText!!.text.isEmpty() || it.editText!!.text.isBlank()) flag = true
        }
        return flag
    }

    @SuppressLint("CutPasteId")
    private fun dialogWhichDirection(
        L: Double,
        isCheckL: Boolean,
        H: Double,
        isCheckH: Boolean,
        L2: Double,
        a2: Double,
        countPublicMeasure: Int?,
        info: String
    ) {
        val view: View =
            layoutInflater.inflate(R.layout.question_which_direction_dimensions_fences, null)
        val alertDialog = AlertDialog.Builder(requireContext())
            .setTitle(resources.getString(R.string.select_direction))
            .setCancelable(false)
            .setView(view)
            .setPositiveButton(android.R.string.ok, null)
            .create()


        val b1 = view.findViewById<MaterialButton>(R.id.button1)
        b1.visibility = View.GONE

        val b2 = view.findViewById<MaterialButton>(R.id.button2)
        b2.visibility = View.GONE

        val b3 = view.findViewById<MaterialButton>(R.id.button3)
        b3.visibility = View.GONE

        val b4 = view.findViewById<MaterialButton>(R.id.button4)
        b4.visibility = View.GONE

        println("CCCCCc")
        println(dimensionsFencesTransit!!.listDf.toString())

        dimensionsFencesTransit!!.listDf.forEachIndexed { index, df ->
            println("$index / $df")
            when (index) {
                0 -> {
                    println("1111")
                    buttonSetting(b1, df.direction, View.VISIBLE)
                }
                1 -> {
                    println("2222")
                    buttonSetting(b2, df.direction, View.VISIBLE)
                }
                2 -> {
                    println("3333")
                    buttonSetting(b3, df.direction, View.VISIBLE)
                }
                3 -> {
                    println("4444")
                    buttonSetting(b4, df.direction, View.VISIBLE)
                }
            }
        }

        val menu = view.findViewById<MaterialButtonToggleGroup>(R.id.menu)

        alertDialog.setOnShowListener {
            val button: Button = (alertDialog as AlertDialog).getButton(AlertDialog.BUTTON_POSITIVE)
            button.setOnClickListener { // TODO Do something
                val btn: Button? = view.findViewById(menu.checkedButtonId)
                if (btn == null) {

                    Toast.makeText(
                        requireContext(),
                        resources.getString(R.string.select_direction),
                        Toast.LENGTH_SHORT
                    ).show()

                } else {
                    // actionSelectedDirection.postValue(Event(btn.text.toString()))
                    alertDialog.dismiss()
                    checkMeasurement(
                        L,
                        isCheckL,
                        H,
                        isCheckH,
                        L2,
                        a2,
                        countPublicMeasure,
                        info,
                        btn.text.toString(),
                        true
                    )
                }
            }
        }


        alertDialog.show()
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun onShowMyLocation(view: View) {
        requestLastLocation(isManual = true)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun onShowUserLocation() {
        requestLastLocation(isManual = false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun requestLastLocation(isManual: Boolean) {
        if (checkPermissions()) {
            showLastLocation()
        } else {
            requestPermissions(isManual)
        }
    }

    @SuppressLint("MissingPermission")
    private fun showLastLocation() {
//        Toast.makeText(requireContext(), "showLastLocation", Toast.LENGTH_SHORT).show()

        lifecycleScope.launch {
            try {
                val location = mFusedLocationClient.lastLocation.await()
//                Toast.makeText(
//                    requireContext(),
//                    "Location: $location",
//                    Toast.LENGTH_SHORT
//                ).show()
                mCurrentLocation = location
            } catch (error: Throwable) {
//                Toast.makeText(
//                    requireContext(),
//                    "showLastLocation error% ${error.message}",
//                    Toast.LENGTH_SHORT
//                ).show()
            }
        }
    }

    /**
     * Return the current state of the permissions needed.
     */
    private fun checkPermissions(): Boolean {
        val permissionState = ActivityCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

        return permissionState == PackageManager.PERMISSION_GRANTED
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun requestPermissions(isManual: Boolean) {
        val shouldProvideRationale =
            shouldShowRequestPermissionRationale(
                Manifest.permission.ACCESS_COARSE_LOCATION
            )

        // Provide an additional rationale to the user. This would happen if the user denied the
        // request previously, but didn't check the "Don't ask again" checkbox.
        if (shouldProvideRationale) {
            // Timber.i("Displaying permission rationale to provide additional context.")
            showSnackbar(
                R.string.default_notification_channel_id,
                R.string.default_notification_channel_id
            ) { // Request permission
                requestPermissions(
                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                    REQUEST_PERMISSIONS_REQUEST_CODE
                )
            }
        } else if (isManual) {
            // Timber.i("Requesting permission")
            // Request permission. It's possible this can be auto answered if device policy
            // sets the permission in a given state or the user denied the permission
            // previously and checked "Never ask again".
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                REQUEST_PERMISSIONS_REQUEST_CODE
            )
        }
    }


    /**
     * Callback received when a permissions request has been completed.
     */
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String?>,
        grantResults: IntArray
    ) {
        // Timber.i("onRequestPermissionResult")
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.size <= 0) {
                // If user interaction was interrupted, the permission request is cancelled and you
                // receive empty arrays.
                // Timber.i("User interaction was cancelled.")
            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showLastLocation()
            } else {
                // Permission denied.

                // Notify the user via a SnackBar that they have rejected a core permission for the
                // app, which makes the Activity useless. In a real app, core permissions would
                // typically be best requested during a welcome-screen flow.

                // Additionally, it is important to remember that a permission might have been
                // rejected without asking the user for permission (device policy or "Never ask
                // again" prompts). Therefore, a user interface affordance is typically implemented
                // when permissions are denied. Otherwise, your app could appear unresponsive to
                // touches or interactions which have required permissions.
                showSnackbar(R.string.default_notification_channel_id,
                    R.string.settings,
                    View.OnClickListener { // Build intent that displays the App settings screen.
                        val intent = Intent()
                        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                        val uri: Uri = Uri.fromParts(
                            "package",
                            BuildConfig.APPLICATION_ID, null
                        )
                        intent.data = uri
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                    })
            }
        }
    }

    private fun getCurrentDateTimeStamp(): Long {
        return (Date().time / 1000)
    }


    private fun showSnackbar(
        mainTextStringId: Int, actionStringId: Int,
        listener: View.OnClickListener
    ) = view?.let { view ->
        Snackbar.make(
            view,
            getString(mainTextStringId),
            Snackbar.LENGTH_LONG
        )
            .setAction(getString(actionStringId), listener)
            .subscribeToLifecycleEvents(this)
            .show()
    }
}