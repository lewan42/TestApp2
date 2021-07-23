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
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.snackbar.Snackbar
import dev.fabula.android.BuildConfig
import dev.fabula.android.R
import dev.fabula.android.app.ui.*
import dev.fabula.android.app.util.Util
import dev.fabula.android.app.util.Util.Companion.cutMeasurement
import dev.fabula.android.bluetooth.GLMDeviceController.*
import dev.fabula.android.camera.CameraViewModel
import dev.fabula.android.databinding.CreateMeasurementsFragmentBinding
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.measurements.create.adapter.CreateMeasurementsListAdapter
import dev.fabula.android.measurements.create.di.CreateMeasurementsComponent
import dev.fabula.android.measurements.model.BoschMeasurements
import dev.fabula.android.measurements.model.Measurement
import kotlinx.android.synthetic.main.canopy_fragment.view.*
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
    private val uidPlatformOfDimension get() = arguments?.getString("uid_platform_of_dimension")
    private val uidCanopy get() = arguments?.getString("uid_canopy")
    private val uidContactWire get() = arguments?.getString("uid_contact_wire")
    private val uidCarrierWire get() = arguments?.getString("uid_carrier_wire")
    private val uidMeasurementType get() = arguments?.getString("uid_measurement_type")

    private val uidDimension get() = arguments?.getString("uid_dimension")
    private val stationDimension get() = arguments?.getString("station_dimension")
    private val uidBridge get() = arguments?.getString("uid_bridge")
    private val canopyType get() = arguments?.getInt("type_canopy")

    private val uid get() = arguments?.getString("uid")
    private val type get() = arguments?.getString("type")
    private var alertDialogCalib: AlertDialog? = null


    private var placeLast: LatLng? = null
    private var placeNew: LatLng? = null

    //private var tmpMeasure: BoschOtgItemList? = null
    private var imageCommentBitmap: Bitmap? = null
    private var uidMeasurement: String? = null
    private var _flag_created: Boolean? = null

    private lateinit var adapter: CreateMeasurementsListAdapter

    private var measurements: MutableList<BoschMeasurements> = mutableListOf()

    /**
     * Code used in requesting runtime permissions.
     */
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 34

    /**
     * Represents a geographical location.
     */
    private var mCurrentLocation: Location? = null

    private val mFusedLocationClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(
            requireContext()
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        CreateMeasurementsComponent.create(context)
            .inject(this)
    }

    private fun dialogNorms() {
        val view: View = layoutInflater.inflate(R.layout.dialog_height_width_norms, null)
        val alertDialog = AlertDialog.Builder(requireContext()).create()
        alertDialog.setTitle("Нормы габаритов приближения строения")
        alertDialog.setCancelable(false)
        alertDialog.setView(view)

        val _width = view.findViewById<View>(R.id.width) as TextView
        val _height = view.findViewById<View>(R.id.height) as TextView

        _width.text = Util.WIDTH_NORM.toString()
        _height.text = Util.HEIGHT_NORM.toString()

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Сохранить") { _, _ ->
            Util.WIDTH_NORM = _width.text.toString().toInt()
            Util.HEIGHT_NORM = _height.text.toString().toInt()
        }

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Закрыть") { _, _ ->

        }

        alertDialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestLastLocation(true)
        CALIBRATION_FLAG = false
        myView = view
        dialogNorms()
        adapter = CreateMeasurementsListAdapter()

        adapter.onItemClick = { boschMeasurement ->
            showTmpMeasurement(boschMeasurement.info)
        }

        alertDialogCalib = AlertDialog.Builder(requireContext()).create()

        val filter = IntentFilter(ACTION_SYNC_CONTAINER_RECEIVED)

        val receiver: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent) {

                var prevResult = Float.MIN_VALUE.toDouble()

                var result = intent.extras!!.getFloat(EXTRA_MEASUREMENT).toDouble()
                var devMode = intent.extras!!.getInt(EXTRA_MEASUREMENT_TYPE).toDouble()
                var gipotinuza = intent.extras!!.getFloat(EXTRA_MEASUREMENT_COMP1).toDouble()
                var ugol = intent.extras!!.getFloat(EXTRA_MEASUREMENT_COMP2).toDouble()

                Log.e("BroadcastReceiver2", "$result / $gipotinuza / $ugol / $devMode")


                if (prevResult != gipotinuza) {
                    prevResult = gipotinuza
                } else {
                    return
                }

                if (!isACTIVE)
                    return

                if (CALIBRATION_FLAG) {

                    gipotinuza *= 1000.0
                    L1 = gipotinuza
                    a1 = ugol

                    L0 = ((L1 + 760) / 2).toDouble()

                    dh = abs(2 * L0 * sin(Math.toRadians(a1)))

                    CALIBRATION_FLAG = false


                    Toast.makeText(requireContext(), "Устройство откалибровано", Toast.LENGTH_SHORT)
                        .show()

                    alertDialogCalib?.hide()

                    if (measurements.size > 0) {
                        measurements.forEach { measure ->

                            val littleMeasurement = calculateMeasure(measure.L2, measure.a2)
                            measure.info = littleMeasurement.info

                            uidPlatform?.let {
                                measure.length = cutMeasurement(littleMeasurement.L.toString())
                                measure.height = cutMeasurement(littleMeasurement.Hvn.toString())
                                measure.isMeasureOverNormal = littleMeasurement.L < Util.WIDTH_NORM || littleMeasurement.Hvn < Util.HEIGHT_NORM
                            }

                            uidCanopy?.let {
                                measure.length = cutMeasurement(littleMeasurement.L.toString())
                                measure.height = cutMeasurement(littleMeasurement.Hvn.toString())
                                measure.isMeasureOverNormal = littleMeasurement.L < Util.WIDTH_NORM || littleMeasurement.Hvn < Util.HEIGHT_NORM
                            }

                            stationDimension?.let {
                                measure.length = cutMeasurement(littleMeasurement.L.toString())
                                measure.height = cutMeasurement(littleMeasurement.Hvn.toString())
                                measure.isMeasureOverNormal = littleMeasurement.L < Util.WIDTH_NORM || littleMeasurement.Hvn < Util.HEIGHT_NORM
                            }

                            uidContactWire?.let {
                                measure.length = "0.0"
                                measure.height = cutMeasurement(littleMeasurement.Hmin.toString())
                                measure.isMeasureOverNormal = littleMeasurement.Hmin < Util.HEIGHT_NORM
                            }

                            uidCarrierWire?.let {
                                measure.length = "0.0"
                                measure.height = cutMeasurement(littleMeasurement.Hmin.toString())
                                measure.isMeasureOverNormal = littleMeasurement.Hmin < Util.HEIGHT_NORM
                            }

                            uidBridge?.let {
                                measure.length = cutMeasurement(littleMeasurement.L.toString())
                                measure.height = "0.0"
                                measure.isMeasureOverNormal = littleMeasurement.L < Util.WIDTH_NORM
                            }
                        }

                        adapter.submitList(measurements)
                        adapter.notifyDataSetChanged()
                        Toast.makeText(requireContext(),"Результаты измерений перерасчитаны",Toast.LENGTH_LONG).show()
                    }

                } else {

                    gipotinuza *= 1000.0
                    L2 = gipotinuza
                    a2 = ugol

                    val littleMeasurement = calculateMeasure(L2, a2)
                    val L = littleMeasurement.L
                    val Hvn = littleMeasurement.Hvn
                    val Hmin = littleMeasurement.Hmin
                    val info = littleMeasurement.info


                    uidPlatform?.let {
                        checkMeasurement(L, true, Hvn, true, L2, a2, false, info)
                    }
                    uidCanopy?.let {
                        checkMeasurement(L, true, Hvn, true, L2, a2, false, info)
                    }

                    stationDimension?.let {
                        checkMeasurement(L, true, Hvn, true, L2, a2, true, info)
                    }

                    uidContactWire?.let {
                        checkMeasurement(0.0, false, Hmin, true, L2, a2, true, info)
                    }

                    uidCarrierWire?.let {
                        checkMeasurement(0.0, false, Hmin, true, L2, a2, true, info)
                    }

                    uidBridge?.let {
                        checkMeasurement(L, true, 0.0, false, L2, a2, false, info)
                    }
                }
            }
        }

        requireContext().registerReceiver(receiver, filter)

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

//                    it.photo1?.let { photo1 ->
//                        imageZamer.setImageBitmap(viewModelCamera.convertImage(photo1))
//                    }

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
                alertDialog.setTitle("Значения каклибровки")
                alertDialog.setCancelable(false)
                alertDialog.setView(_view)

                val _width = _view.findViewById<View>(R.id.length) as TextView
                val _height = _view.findViewById<View>(R.id.height) as TextView
                val _angle = _view.findViewById<View>(R.id.angle) as TextView

                _width.text = L0.toString()
                _height.text = dh.toString()
                _angle.text = a1.toString()


                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Закрыть") { _, _ ->

                }

                alertDialog.setButton(
                    AlertDialog.BUTTON_NEGATIVE,
                    "Произвести калибровку"
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

    private fun calculateMeasure(
        L2: Double,
        a2: Double
    ): LittleMeasurement {

        val dx = L0 - L1
        val dL = dx * cos(Math.toRadians(a1))
        val dh3 =
            (L0 - dx) * sin(Math.toRadians(a1))
        val Ldk = cos(Math.toRadians(a2)) * L2
        val Hdk = sin(Math.toRadians(a2)) * L2
        val L = Ldk + dL
        val Hvn = Hdk - dh3

        val Hmin = if (a1 <= 0) {
            Hvn - (abs(L0 * sin(Math.toRadians(a1))) * sin(
                Math.toRadians(a2)
            ))
        } else {
            Hvn
        }

        val info = String.format(
            "[L0: %f]  - ось пути (мм)" +
                    "\n[dh: %f] - возвышение рельса (мм)" +
                    "\n[dx: %f] - отступ по оси (мм)" +
                    "\n[dL: %f] - поправка по длине (мм)" +
                    "\n[dh3: %f] - поправка по высоте (мм)" +
                    "\n[Ldk: %f] - косвенная длина (мм)" +
                    "\n[Hdk: %f] - косвенная высота (мм)" +
                    "\n[L: %f] - длина от оси пути (мм)" +
                    "\n[Hvn: %f] - высота от головки вн. рельса (мм)" +
                    "\n[a1: %f] - угол наклона рельсов (мм)" +
                    "\n[a2: %f] - угол от горизонта до точки (мм)" +
                    "\n[Hmin: %f] - для контактного кабеля и горизонтальных объектов (мм)" +
                    "\n\n",
            L0, dh, dx, dL, dh3, Ldk, Hdk, L, Hvn, a1, a2, Hmin
        )

        return LittleMeasurement(L, Hvn, Hmin, info)
    }

    private fun checkMeasurement(
        L: Double,
        isCheckL: Boolean,
        H: Double,
        isCheckH: Boolean,
        L2: Double,
        a2: Double,
        single: Boolean,
        info: String
    ) {
        if (isCheckL && isCheckH) {

            if (L < Util.WIDTH_NORM || H < Util.HEIGHT_NORM) {
                isACTIVE = false
                dialogMeasureOverNorm(L, H, L2, a2, single, info)

            } else {
                addMeasure(L, H, L2, a2, single, info, false)
            }

        } else if (isCheckL && !isCheckH) {

            if (L < Util.WIDTH_NORM) {
                isACTIVE = false
                dialogMeasureOverNorm(L, H, L2, a2, single, info)

            } else {
                addMeasure(L, H, L2, a2, single, info, false)
            }

        } else if (!isCheckL && isCheckH) {

            if (H < Util.HEIGHT_NORM) {
                isACTIVE = false
                dialogMeasureOverNorm(L, H, L2, a2, single, info)

            } else {
                addMeasure(L, H, L2, a2, single, info, false)
            }
        }
    }

    private fun addMeasure(
        L: Double,
        H: Double,
        L2: Double,
        a2: Double,
        single: Boolean,
        info: String,
        isMeasureOverNormal: Boolean
    ) {
        if (!single) {
            addMeasurementToList(
                cutMeasurement(L.toString()),
                cutMeasurement(H.toString()),
                L2,
                a2,
                "0.0",
                "0.0", info, isMeasureOverNormal
            )

        } else{
            measurements.clear()
            addMeasurementToList(
                cutMeasurement(L.toString()),
                cutMeasurement(H.toString()),
                L2,
                a2,
                "0.0",
                "0.0", info, isMeasureOverNormal
            )
        }
    }

    private fun dialogMeasureOverNorm(
        L: Double, H: Double, L2: Double, a2: Double, single: Boolean, info: String
    ) {
        var dialog = AlertDialog.Builder(myView.context).create()
        dialog.setTitle("Значения измерения меньше нормы")
        dialog.setCancelable(false)

        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Перемерить") { _, _ ->
            isACTIVE = true
        }
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Сохранить измерение") { _, _ ->
            isACTIVE = true
            addMeasure(L, H, L2, a2, single, info, true)
        }

        dialog.show()
    }

    private fun waitCalibrationMeasurement() {

        CALIBRATION_FLAG = true

        alertDialogCalib!!.setTitle("Калибровка")
        alertDialogCalib!!.setCancelable(false)
        alertDialogCalib!!.setMessage("Произведите измерение")

        alertDialogCalib!!.setButton(AlertDialog.BUTTON_POSITIVE, "Отменить") { _, _ ->
            CALIBRATION_FLAG = false
        }

        alertDialogCalib!!.show()
    }

    private fun showTmpMeasurement(strMeasurement: String) {

        val dialog = AlertDialog.Builder(requireContext()).create()

        dialog.setTitle("Подробные измерения")
        dialog.setCancelable(false)
        dialog.setMessage(strMeasurement)

        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ок") { _, _ ->

        }

        dialog.show()
    }


    private fun addMeasurementToList(
        length: String,
        height: String,
        L2: Double,
        a2: Double,
        ugol: String,
        gipotinuza: String,
        info: String,
        isMeasureOverNormal: Boolean
    ) {
        measurements.add(
            BoschMeasurements(
                length,
                height,
                L2,
                a2,
                ugol,
                gipotinuza,
                info,
                isMeasureOverNormal
            )
        )

        adapter.submitList(measurements)
        adapter.notifyDataSetChanged()
    }

    private fun pifagor(c: Double, k: Double): Double {
        return sqrt((c.pow(2) - k.pow(2)))
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

            //val izmerPhoto = viewModelCamera.convertImage(imageZamer)
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

            stationDimension?.let { station ->
                Timber.i("Try send measurement to server stationDimension")

                var dimen_uid = ""
                if (flag_edited == null || flag_edited == false) {
                    dimen_uid = UUID.randomUUID().toString()
                } else {
                    uidDimension?.let {
                        dimen_uid = it
                        Timber.i("stationDimension -> dimen_uid = it - > ${dimen_uid}")
                    }
                }


                uidPlatformOfDimension?.let { platformUidOfDimension ->
                    viewModel.createDimensionAndMeasurement(
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
                            dimen_uid,
                            null,
                            null,
                            null,
                            uidMeasurementType,
                            flag_created,
                            flag_edited,
                            getCurrentDateTimeStamp()
                        ),
                        DimensionsFence(
                            dimen_uid,
                            platformUidOfDimension,
                            station,
                            flag_created,
                            flag_edited
                        )
                    )
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

    inner class LittleMeasurement(
        var L: Double,
        var Hvn: Double,
        var Hmin: Double,
        var info: String
    )
}