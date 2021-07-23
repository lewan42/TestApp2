package dev.fabula.android.measurements.union.list.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.LayoutHeaderViewHolder
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.showMessage
import dev.fabula.android.app.util.Util.Companion.cutMeasurement
import dev.fabula.android.camera.CameraViewModel
import dev.fabula.android.databinding.UnionMeasurementListFragmentBinding
import dev.fabula.android.measurements.model.Measurement
import dev.fabula.android.measurements.union.list.adapter.UnionMeasurementListAdapter
import dev.fabula.android.measurements.union.list.di.UnionMeasurementsListComponent
import java.io.File

class UnionMeasurementsListFragment :
    ViewModelFragment<UnionMeasurementListFragmentBinding>(R.layout.union_measurement_list_fragment) {

    private lateinit var adapter: UnionMeasurementListAdapter

    private val viewModel: UnionMeasurementsListViewModel by activityViewModel()
    private val viewModelCamera: CameraViewModel by activityViewModel()

    private var existMeasurements: List<Measurement> = listOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        UnionMeasurementsListComponent.create(context)
            .inject(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UnionMeasurementListAdapter()

        viewModel.data.observe(viewLifecycleOwner) { otgList ->
            if (otgList.isEmpty())
                showMessage(R.string.data_otg_bosch_is_empty)
            otgList.forEach { otgListItem ->


                existMeasurements.forEach { bleListItem ->
                    if (bleListItem.photo1 == null) {

                        if (cutMeasurement(bleListItem.gipotinuza) == cutMeasurement(otgListItem.value1) &&
                            cutMeasurement(bleListItem.ugol_naklona) == cutMeasurement(otgListItem.value2)
                        ) {
                            viewModelCamera.convertImage(otgListItem.bitmap)?.let { strImage ->
                                bleListItem.photo1 = strImage
                                bleListItem.photo2 = strImage
                                viewModel.photoUpdate(
                                    bleListItem.uid,
                                    strImage
                                )
                            }
                        }
                    }
                }
            }

        }

        viewModel.measurements.observe(viewLifecycleOwner) {
            existMeasurements = it
            adapter.submitList(it)
            viewModel.getDataFromBoschDevice(File("/storage/usbotg/Memory.txt"), requireContext())
        }

        binding = UnionMeasurementListFragmentBinding.bind(view).apply {
            recyclerView.adapter = adapter

            btnSyncPhoto.setOnClickListener {
                viewModel.getMeasurements2()

                viewModel.measurements2.observe(viewLifecycleOwner) {
                    adapter.submitList(it)
                }
            }

            viewModel.getMeasurements()

            LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                onItemClickButtonBack = {
                    findNavController().navigateUp()
                }
            }.bind("Все измерения")
        }
    }
}