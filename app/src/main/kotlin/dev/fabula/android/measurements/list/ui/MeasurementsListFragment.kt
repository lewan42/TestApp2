package dev.fabula.android.measurements.list.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.LayoutHeaderViewHolder
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.event
import dev.fabula.android.app.ui.hideKeyboard
import dev.fabula.android.app.util.Util
import dev.fabula.android.databinding.MeasurementsListFragmentBinding
import dev.fabula.android.measurements.list.adapter.MeasurementsListAdapter
import dev.fabula.android.measurements.list.di.MeasurementsListComponent
import kotlinx.android.synthetic.main.measurements_list_fragment.view.*

class MeasurementsListFragment :
    ViewModelFragment<MeasurementsListFragmentBinding>(R.layout.measurements_list_fragment) {

    private val uidPlatform get() = arguments?.getString("uid_platform")
    private val uidBridge get() = arguments?.getString("uid_bridge")
    private val uidCanopy get() = arguments?.getString("uid_canopy")
    private lateinit var adapter: MeasurementsListAdapter
    private var startCountMeasure = 1

    private val viewModel: MeasurementsListViewModel by activityViewModel()
    private val bundle = Bundle()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MeasurementsListComponent.create(context)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = when {
            uidPlatform != null -> MeasurementsListAdapter("платформы")
            uidBridge != null -> MeasurementsListAdapter("спуска")
            uidCanopy != null -> MeasurementsListAdapter("навеса")
            else -> MeasurementsListAdapter("")
        }

        adapter.onItemClick = { measurement ->
            val bundle = Bundle()
            if (measurement.parent_platform_uid != null)
                bundle.putString("uid_platform", measurement.parent_platform_uid)

            if (measurement.parent_most_perehod_uid != null)
                bundle.putString("uid_bridge", measurement.parent_most_perehod_uid)

            if (measurement.parent_gabarit_naves_uid != null)
                bundle.putString("uid_canopy", measurement.parent_gabarit_naves_uid)

            bundle.putString("uid", measurement.uid)
            findNavController().navigate(R.id.create_measurementsFragment, bundle)
        }

        viewModel.countLastMeasurementPlatforms.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
            binding?.progressBar?.visibility = View.INVISIBLE
            Toast.makeText(requireContext(), "Найдено ${it.size} измерений", Toast.LENGTH_SHORT).show()
        }

        viewModel.countLastMeasurementBridge.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
            binding?.progressBar?.visibility = View.INVISIBLE
            Toast.makeText(requireContext(), "Найдено ${it.size} измерений", Toast.LENGTH_SHORT).show()
        }

        viewModel.countLastMeasurementCanopy.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
            binding?.progressBar?.visibility = View.INVISIBLE
            Toast.makeText(requireContext(), "Найдено ${it.size} измерений", Toast.LENGTH_SHORT).show()
        }

        viewModel.uidCanopyOfPlatform.event(viewLifecycleOwner) {
            it?.let {

                bundle.putString("uid_canopy", it)
                findNavController().navigate(R.id.canopyFragment, bundle)
            }
        }


        binding = MeasurementsListFragmentBinding.bind(view).apply {
            recyclerView.adapter = adapter

            countDay.setText(startCountMeasure.toString())

            searchMeasure.setOnClickListener {
                if(countDay.text.toString() == ""){
                    Toast.makeText(requireContext(), "Введите количество последних измерений", Toast.LENGTH_LONG).show()
                }else {
                    hideKeyboard()
                    uidPlatform?.let { uidPlatform ->
                        viewModel.getCountLastMeasurementsOfPlatform(uidPlatform, countDay.text.toString().toInt())
                        progressBar.visibility = View.VISIBLE
                    }

                    uidBridge?.let { uidBridge ->
                        viewModel.getCountLastMeasurementsOfBridge(uidBridge, countDay.text.toString().toInt())
                        progressBar.visibility = View.VISIBLE
                    }

                    uidCanopy?.let { uidCanopy ->
                        viewModel.getCountLastMeasurementsOfCanopy(uidCanopy, countDay.text.toString().toInt())
                        progressBar.visibility = View.VISIBLE
                    }
                }
            }

            viewModel.typeMeasurementByTypeOf.event(viewLifecycleOwner) {
                bundle.putString("uid_measurement_type", it.uid)
                findNavController().navigate(R.id.create_measurementsFragment, bundle)
            }

            uidPlatform?.let { uidPlatform ->
                viewModel.getCountLastMeasurementsOfPlatform(uidPlatform, startCountMeasure)
                btnAdd.setOnClickListener {
                    bundle.putString("uid_platform", uidPlatform)
                    viewModel.getTypeMeasurementByType(Util.platform_type_measurement)
                }
            }

            uidBridge?.let { uidBridge ->
                viewModel.getCountLastMeasurementsOfBridge(uidBridge, startCountMeasure)

                btnAdd.setOnClickListener {
                    bundle.putString("uid_bridge", uidBridge)
                    viewModel.getTypeMeasurementByType(Util.bridge_down)
                }
            }

            uidCanopy?.let { uidCanopy ->
                viewModel.getCountLastMeasurementsOfCanopy(uidCanopy, startCountMeasure)

                btnAdd.setOnClickListener {
                    bundle.putString("uid_canopy", uidCanopy)
                    viewModel.getTypeMeasurementByType(Util.dimensions_canopy_type)
                }
            }

            LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                onItemClickImage = {
                    findNavController().navigate(R.id.action_measurements_list_to_profile)
                }
                onItemClickButtonBack = {
                    findNavController().navigateUp()
                }
            }.bind(getHeaderName())
        }
    }

    private fun getHeaderName():String{
        uidPlatform?.let { _ ->
            return "Измерения платформы"
        }

        uidBridge?.let { _ ->
            return "Измерения мостового перехода"
        }

        uidCanopy?.let { _ ->
            return "Измерения навеса"
        }

        return "Измерения"
    }
}
