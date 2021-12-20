package dev.fabula.android.measurements.list.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.fabula.android.R
import dev.fabula.android.app.ui.LayoutHeaderViewHolder
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.event
import dev.fabula.android.app.ui.hideKeyboard
import dev.fabula.android.app.util.Util
import dev.fabula.android.databinding.MeasurementsListFragmentBinding
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.dimensions.fence.model.DimensionsFenceTransit
import dev.fabula.android.dimensions.fence.model.DimensionsFenceWithMeasurement
import dev.fabula.android.measurements.list.adapter.MeasurementsListAdapter
import dev.fabula.android.measurements.list.di.MeasurementsListComponent
import dev.fabula.android.measurements.model.Measurement


class MeasurementsListFragment :
    ViewModelFragment<MeasurementsListFragmentBinding>(R.layout.measurements_list_fragment) {

    private val uidPlatform get() = arguments?.getString("uid_platform")
    private val uidBridge get() = arguments?.getString("uid_bridge")
    private val uidCanopy get() = arguments?.getString("uid_canopy")

    private val dimensionFenceTransit get() = arguments?.getString("dimension_fences_json_data")

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

        adapter = MeasurementsListAdapter()

        adapter.onItemClick = { itemRow ->
            val bundle = Bundle()

            when (itemRow) {
                is Measurement -> {
                    if (itemRow.parent_platform_uid != null)
                        bundle.putString("uid_platform", itemRow.parent_platform_uid)

                    if (itemRow.parent_most_perehod_uid != null)
                        bundle.putString("uid_bridge", itemRow.parent_most_perehod_uid)

                    if (itemRow.parent_gabarit_naves_uid != null)
                        bundle.putString("uid_canopy", itemRow.parent_gabarit_naves_uid)

                    bundle.putString("uid", itemRow.uid)
                }

                is DimensionsFenceWithMeasurement ->{
                    itemRow.measurements?.let{ measure ->
                        if (itemRow.measurements != null)
                            bundle.putString("uid_dimension", measure.parent_gabarit_tor_uid)

                        bundle.putString("uid", measure.uid)
                    }
                }
            }

            findNavController().navigate(R.id.create_measurementsFragment, bundle)
        }

        viewModel.countLastMeasurementPlatforms.event(viewLifecycleOwner) {
            println("result MeasurementsListFragment uidPlatform ${it.toString()}")

            adapter.submitList(it)
            adapter.notifyDataSetChanged()
            binding?.progressBar?.visibility = View.INVISIBLE
            showCountMeasurement(it.size)
        }

        viewModel.countLastMeasurementBridge.event(viewLifecycleOwner) {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
            binding?.progressBar?.visibility = View.INVISIBLE
            showCountMeasurement(it.size)
        }

        viewModel.countLastMeasurementCanopy.event(viewLifecycleOwner) {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
            binding?.progressBar?.visibility = View.INVISIBLE
            showCountMeasurement(it.size)
        }

        viewModel.countLastMeasurementDimensionFence.event(viewLifecycleOwner) {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
            binding?.progressBar?.visibility = View.INVISIBLE
            showCountMeasurement(it.size)
        }

        binding = MeasurementsListFragmentBinding.bind(view).apply {
            recyclerView.adapter = adapter

            countDay.setText(startCountMeasure.toString())

            searchMeasure.setOnClickListener {
                if (countDay.text.toString().isEmpty() || countDay.text.toString().isBlank()) {
                    Toast.makeText(
                        requireContext(),
                        resources.getString(R.string.enter_the_number_of_last_measurements),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    hideKeyboard()
                    uidPlatform?.let { uidPlatform ->
                        println("start MeasurementsListFragment uidPlatform $uidPlatform")
                        viewModel.getCountLastMeasurementsOfPlatform(
                            uidPlatform,
                            countDay.text.toString().toInt()
                        )
                        progressBar.visibility = View.VISIBLE
                    }

                    uidBridge?.let { uidBridge ->
                        viewModel.getCountLastMeasurementsOfBridge(
                            uidBridge,
                            countDay.text.toString().toInt()
                        )
                        progressBar.visibility = View.VISIBLE
                    }

                    uidCanopy?.let { uidCanopy ->
                        viewModel.getCountLastMeasurementsOfCanopy(
                            uidCanopy,
                            countDay.text.toString().toInt()
                        )
                        progressBar.visibility = View.VISIBLE
                    }

                    dimensionFenceTransit?.let { json ->
                        val dimensionsFencesTransit: DimensionsFenceTransit = Gson().fromJson(
                            json,
                            object : TypeToken<DimensionsFenceTransit?>() {}.type
                        )

                        viewModel.getCountLastMeasurementsOfDimensionFences(
                            dimensionsFencesTransit.listDf,
                            countDay.text.toString().toInt()
                        )
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

            dimensionFenceTransit?.let { json ->
                val dimensionsFenceTransit: DimensionsFenceTransit = Gson().fromJson(
                    json,
                    object : TypeToken<DimensionsFenceTransit?>() {}.type
                )

                viewModel.getCountLastMeasurementsOfDimensionFences(
                    dimensionsFenceTransit.listDf,
                    countDay.text.toString().toInt()
                )

                btnAdd.setOnClickListener {
                    bundle.putString("dimension_fences_json_data", json)
                    viewModel.getTypeMeasurementByType(Util.dimensions_fence_type)
                }
            }

            LayoutHeaderViewHolder(layoutHeader, requireContext()).apply {
                onItemClickImage = {
                    findNavController().navigate(R.id.action_measurements_list_to_profile)
                }
                onItemClickButtonBack = {
                    findNavController().navigateUp()
                }
            }.bind(getHeaderName())
        }
    }

    private fun showCountMeasurement(count: Int) {
        Toast.makeText(
            requireContext(),
            "${resources.getString(R.string.found)} $count ${resources.getString(R.string.measurements_)}",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun getHeaderName(): String {
        uidPlatform?.let { _ ->
            return resources.getString(R.string.platform_measurement)
        }

        uidBridge?.let { _ ->
            return resources.getString(R.string.bridge_cross_measurement)
        }

        uidCanopy?.let { _ ->
            return resources.getString(R.string.canopy_measurement)
        }

        return resources.getString(R.string.measurements)
    }
}
