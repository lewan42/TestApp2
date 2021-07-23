package dev.fabula.android.canopy.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.LayoutHeaderViewHolder
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.event
import dev.fabula.android.app.ui.showMessage
import dev.fabula.android.app.util.Util
import dev.fabula.android.canopy.di.CanopyComponent
import dev.fabula.android.databinding.CanopyFragmentBinding
import timber.log.Timber
import java.lang.Exception

class CanopyFragment : ViewModelFragment<CanopyFragmentBinding>(R.layout.canopy_fragment) {

    private val platformUID get() = arguments?.getString("uid_platform")
    private val canopyUID get() = arguments?.getString("uid_canopy")
    private val viewModel: CanopyViewModel by activityViewModel()

    private var ACTION_TYPE = Util.canopy_type_north

    override fun onAttach(context: Context) {
        super.onAttach(context)
        CanopyComponent.create(context)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = CanopyFragmentBinding.bind(view).apply {

            canopyUID?.let { it1 -> viewModel.measurementsOfCanopy(it1) }

            viewModel.measurementsOfCanopy.event(viewLifecycleOwner) { list ->

                try {
                    gNorth.setText(list[0].vertical_gabarit)
                    vNorth.setText(list[0].horizontal_gabarit)

                    gCenter.setText(list[1].vertical_gabarit)
                    vCenter.setText(list[1].horizontal_gabarit)

                    gSouth.setText(list[2].vertical_gabarit)
                    vSouth.setText(list[2].horizontal_gabarit)
                } catch (e: Exception) {
                    Timber.e("viewModel.measurementsOfCanopy: ${e.message}")
                }
            }

            btnSave.setOnClickListener {
                if (gNorth.text.isNullOrEmpty() || vNorth.text.isNullOrEmpty() ||
                    gCenter.text.isNullOrEmpty() || vCenter.text.isNullOrEmpty() ||
                    gSouth.text.isNullOrEmpty() || vSouth.text.isNullOrEmpty()
                ) {
                    showMessage(R.string.fill_in_all_fields)
                    return@setOnClickListener
                }

                canopyUID?.let { it1 -> viewModel.getCanopyByIdForSave(it1) }
            }

            viewModel.updateMeasurementOfCanopy.event(viewLifecycleOwner) {
                if (it) {
                    showMessage(R.string.data_added_success)
                    findNavController().navigateUp()

                } else showMessage(R.string.data_added_error)
            }

            viewModel.canopyForSave.event(viewLifecycleOwner) { canopy ->
                if (canopy.north_uid == null) {
                    showMessage(R.string.create_measurement_for_north)
                    return@event
                } else if (canopy.center_uid == null) {
                    showMessage(R.string.create_measurement_for_center)
                    return@event
                } else if (canopy.south_uid == null) {
                    showMessage(R.string.create_measurement_for_south)
                    return@event
                }

                viewModel.updateMeasurementOfCanopy(
                    canopy.uid,
                    canopy.north_uid,
                    gNorth.text.toString(),
                    vNorth.text.toString(),
                    canopy.center_uid,
                    gCenter.text.toString(),
                    vCenter.text.toString(),
                    canopy.south_uid,
                    gSouth.text.toString(),
                    vSouth.text.toString()
                )
            }

            viewModel.canopy.event(viewLifecycleOwner) { canopy ->
                canopy.let {
                    val bundle = Bundle()
                    bundle.putString("uid_canopy", it.uid)
                    when (ACTION_TYPE) {

                        //north
                        Util.canopy_type_north -> {
                            if (it.north_uid != null) {
                                bundle.putString("uid", it.north_uid)
                            }
                            bundle.putInt("type_canopy", Util.canopy_type_north)
                        }
                        //center
                        Util.canopy_type_center -> {
                            if (it.center_uid != null)
                                bundle.putString("uid", it.center_uid)
                            bundle.putInt("type_canopy", Util.canopy_type_center)
                        }
                        //south
                        Util.canopy_type_south -> {
                            if (it.south_uid != null)
                                bundle.putString("uid", it.south_uid)
                            bundle.putInt("type_canopy", Util.canopy_type_south)
                        }
                    }
                    findNavController().navigate(
                        R.id.action_canopy_to_create_measurement,
                        bundle
                    )
                }
            }

            btnActionNorth.setOnClickListener {
                canopyUID?.let { uid ->
                    ACTION_TYPE = Util.canopy_type_north
                    viewModel.getCanopyById(uid)
                }
            }

            btnActionCenter.setOnClickListener {
                canopyUID?.let { uid ->
                    ACTION_TYPE = Util.canopy_type_center
                    viewModel.getCanopyById(uid)
                }
            }

            btnActionSouth.setOnClickListener {
                canopyUID?.let { uid ->
                    ACTION_TYPE = Util.canopy_type_south
                    viewModel.getCanopyById(uid)
                }
            }


            LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                onItemClickImage = {
                    findNavController().navigate(R.id.action_canopy_to_profile)
                }
                onItemClickButtonBack = {
                    findNavController().navigateUp()
                }
            }.bind("${resources.getString(R.string.platform)}")
        }
    }
}