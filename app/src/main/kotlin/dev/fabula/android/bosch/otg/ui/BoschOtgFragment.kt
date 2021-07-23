package dev.fabula.android.bosch.otg.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.Event
import dev.fabula.android.app.ui.LayoutHeaderViewHolder
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.bosch.otg.adapter.BoschOtgAdapter
import dev.fabula.android.bosch.otg.di.BoschOtgComponent
import dev.fabula.android.databinding.BoschOtgFragmentBinding
import dev.fabula.android.measurements.create.ui.CreateMeasurementsViewModel
import java.io.File

class BoschOtgFragment :
    ViewModelFragment<BoschOtgFragmentBinding>(R.layout.bosch_otg_fragment) {

    private val viewModel: BoschOtgViewModule by activityViewModel()
    private val viewModelParent: CreateMeasurementsViewModel by activityViewModel()

    private lateinit var adapter: BoschOtgAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        BoschOtgComponent.create(context)
            .inject(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = BoschOtgAdapter()
        adapter.onItemClick = {
            viewModelParent.objectMeasurement.postValue(Event(it))
            findNavController().navigateUp()
        }

        binding = BoschOtgFragmentBinding.bind(view).apply {
            try {
                viewModel.getDataFromBoschDevice(File("/storage/usbotg/Memory.txt"), view.context)

                viewModel.data.observe(viewLifecycleOwner) {
                    adapter.submitList(it)
                }
            } catch (e: Exception) {
            }

            recyclerView.adapter = adapter

            LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                onItemClickImage = {
                    findNavController().navigate(R.id.action_bosch_otg_to_profile)
                }
                onItemClickButtonBack = {
                    findNavController().navigateUp()
                }
            }.bind("Список измерений")
        }
    }
}