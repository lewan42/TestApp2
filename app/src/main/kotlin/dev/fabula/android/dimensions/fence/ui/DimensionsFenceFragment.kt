package dev.fabula.android.dimensions.fence.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.LayoutHeaderViewHolder
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.event
import dev.fabula.android.app.ui.showMessage
import dev.fabula.android.databinding.DimensionsFenceFragmentBinding
import dev.fabula.android.dimensions.fence.di.DimensionsFenceComponent
import dev.fabula.android.dimensions.fence.model.DimensionSaveDB
import timber.log.Timber

class DimensionsFenceFragment :
    ViewModelFragment<DimensionsFenceFragmentBinding>(R.layout._dimensions_fence_fragment) {

    private val platformUID get() = arguments?.getString("uid_platform")
    private val platformName get() = arguments?.getString("name_platform")
    private val dimensionCount get() = arguments?.getInt("dimensions_count")
    private val viewModel: DimensionsFenceViewModule by activityViewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DimensionsFenceComponent.create(context)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.dimensionUpdate.event(viewLifecycleOwner) {
            if (it) {
                showMessage(R.string.data_added_success)
            } else showMessage(R.string.data_added_error)
        }

        platformUID?.let { it1 -> viewModel.fetchDimensionList(it1) }


        binding = DimensionsFenceFragmentBinding.bind(view).apply {
            platformName?.let {
                LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                    onItemClickImage = {
                        findNavController().navigate(R.id.action_dimensions_fence_to_profile)
                    }
                    onItemClickButtonBack = {
                        findNavController().navigateUp()
                    }
                }.bind(it)
            }

            platformUID?.let {
                dimensionCount?.let { count ->
                    if (count == 2) {
                        row3.visibility = View.GONE
                        row4.visibility = View.GONE
                    }
                }
            }

            viewModel.dimensionFence.observe(viewLifecycleOwner) { list ->
                Timber.e("viewModel.dimensionFence.observe")
                try {
                    station1.setText(list[0].direction)
                    v1.setText(list[0].horizontal)
                    g1.setText(list[0].vertical)

                    station2.setText(list[1].direction)
                    v2.setText(list[1].horizontal)
                    g2.setText(list[1].vertical)

                    station3.setText(list[2].direction)
                    v3.setText(list[2].horizontal)
                    g3.setText(list[2].vertical)

                    station4.setText(list[3].direction)
                    v4.setText(list[3].horizontal)
                    g4.setText(list[3].vertical)

                } catch (e: Exception) {
                    Log.e("DimensionsFenceFragment", "onViewCreated: ${e.message}")
                }

                val bundle = Bundle()
                btnAction1.setOnClickListener {
                    Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener")
                    if (station1.text.isNullOrEmpty()) {
                        Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener -> empty")
                        showMessage(R.string.fill_station_name)
                    } else {
                        Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener -> else")
                        try {
                            bundle.putString("station_dimension", station1.text.toString())
                            bundle.putString("uid_platform_of_dimension", platformUID)
                            list[0].measurement_uid?.let {
                                bundle.putString("uid", it)
                            }
                            list[0].uid?.let {
                                bundle.putString("uid_dimension", it)
                            }
                            list[0].measurement_uid_type?.let {
                                bundle.putString("uid_measurement_type", it)
                            }
                        } catch (e: Exception) {
                            Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener -> ${e.message}")
                        }
                        findNavController().navigate(
                            R.id.action_dimensions_fence_to_create_measurement,
                            bundle
                        )
                    }
                }

                btnAction2.setOnClickListener {
                    Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener")
                    if (station2.text.isNullOrEmpty()) {
                        Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener -> empty")
                        showMessage(R.string.fill_station_name)
                    } else {
                        Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener -> else")
                        try {
                            bundle.putString("station_dimension", station2.text.toString())
                            bundle.putString("uid_platform_of_dimension", platformUID)
                            list[1].measurement_uid?.let {
                                bundle.putString("uid", it)
                            }
                            list[1].uid?.let {
                                bundle.putString("uid_dimension", it)
                            }
                            list[1].measurement_uid_type?.let {
                                bundle.putString("uid_measurement_type", it)
                            }
                        } catch (e: Exception) {
                            Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener -> ${e.message}")
                        }
                        findNavController().navigate(
                            R.id.action_dimensions_fence_to_create_measurement,
                            bundle
                        )
                    }
                }

                btnAction3.setOnClickListener {
                    Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener")
                    if (station3.text.isNullOrEmpty()) {
                        Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener -> empty")
                        showMessage(R.string.fill_station_name)
                    } else {
                        Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener -> else")
                        try {
                            bundle.putString("station_dimension", station3.text.toString())
                            bundle.putString("uid_platform_of_dimension", platformUID)
                            list[2].measurement_uid?.let {
                                bundle.putString("uid", it)
                            }
                            list[2].uid?.let {
                                bundle.putString("uid_dimension", it)
                            }
                            list[2].measurement_uid_type?.let {
                                bundle.putString("uid_measurement_type", it)
                            }
                        } catch (e: Exception) {
                            Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener -> ${e.message}")
                        }
                        findNavController().navigate(
                            R.id.action_dimensions_fence_to_create_measurement,
                            bundle
                        )
                    }
                }

                btnAction4.setOnClickListener {
                    Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener")
                    if (station4.text.isNullOrEmpty()) {
                        Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener -> empty")
                        showMessage(R.string.fill_station_name)
                    } else {
                        Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener -> else")
                        try {
                            bundle.putString("station_dimension", station4.text.toString())
                            bundle.putString("uid_platform_of_dimension", platformUID)
                            list[3].measurement_uid?.let {
                                bundle.putString("uid", it)
                            }
                            list[3].uid?.let {
                                bundle.putString("uid_dimension", it)
                            }
                            list[3].measurement_uid_type?.let {
                                bundle.putString("uid_measurement_type", it)
                            }
                        } catch (e: Exception) {
                            Timber.e("viewModel.dimensionFence.observe -> btnAction1.setOnClickListener -> ${e.message}")
                        }
                        findNavController().navigate(
                            R.id.action_dimensions_fence_to_create_measurement,
                            bundle
                        )
                    }
                }

                btnAdd.setOnClickListener {
                    when (dimensionCount) {
                        2 -> {
                            if (station1.text.isNullOrEmpty() || station2.text.isNullOrEmpty()) {
                                showMessage(R.string.fill_in_all_fields)
                                return@setOnClickListener
                            }
                        }

                        4 -> {
                            if (station1.text.isNullOrEmpty() || station2.text.isNullOrEmpty() ||
                                station3.text.isNullOrEmpty() || station4.text.isNullOrEmpty()) {
                                showMessage(R.string.fill_in_all_fields)
                                return@setOnClickListener
                            }
                        }
                    }

                    when (dimensionCount) {
                        2 -> {
                            try {
                                viewModel.updateDimension(
                                    listOf(
                                        DimensionSaveDB(
                                            list[0].uid,
                                            g1.text.toString(),
                                            v1.text.toString(),
                                            station1.text.toString()
                                        ),
                                        DimensionSaveDB(
                                            list[1].uid,
                                            g2.text.toString(),
                                            v2.text.toString(),
                                            station2.text.toString()
                                        )
                                    )
                                )
                            } catch (e: Exception) {
                                showMessage(R.string.data_added_error)
                            }
                        }

                        4 -> {
                            try {
                                viewModel.updateDimension(
                                    listOf(
                                        DimensionSaveDB(
                                            list[0].uid,
                                            g1.text.toString(),
                                            v1.text.toString(),
                                            station1.text.toString()
                                        ),
                                        DimensionSaveDB(
                                            list[1].uid,
                                            g2.text.toString(),
                                            v2.text.toString(),
                                            station2.text.toString()
                                        ),
                                        DimensionSaveDB(
                                            list[2].uid,
                                            g3.text.toString(),
                                            v3.text.toString(),
                                            station3.text.toString()
                                        ),
                                        DimensionSaveDB(
                                            list[3].uid,
                                            g4.text.toString(),
                                            v4.text.toString(),
                                            station4.text.toString()
                                        )
                                    )
                                )
                            } catch (e: Exception) {
                                showMessage(R.string.data_added_error)
                            }
                        }
                    }

                }
            }
        }
    }
}