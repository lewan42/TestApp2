package dev.fabula.android.screen.measurements.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dev.fabula.android.R
import dev.fabula.android.app.ui.LayoutHeaderViewHolder
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.util.Util
import dev.fabula.android.databinding.ScreenMeasurementsFragmentBinding
import dev.fabula.android.list.items.model.ListItem
import dev.fabula.android.railway.model.Railway
import dev.fabula.android.screen.measurements.adapter.ScreenMeasurementsAdapter
import dev.fabula.android.screen.measurements.di.ScreenMeasurementsComponent
import dev.fabula.android.section.model.RailwaySection

class ScreenMeasurementsFragment :
    ViewModelFragment<ScreenMeasurementsFragmentBinding>(R.layout.screen_measurements_fragment) {

    private val railway get() = arguments?.getParcelable<Railway>("railway")
    private val railwaySection get() = arguments?.getParcelable<RailwaySection>("railwaySection")
    private lateinit var adapter: ScreenMeasurementsAdapter
    private val viewModel: ScreenMeasurementsViewModule by activityViewModel()
    private var FILTER_QUERY: String = ""
    private var FILTER_TYPE: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ScreenMeasurementsComponent.create(context)
            .inject(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ScreenMeasurementsAdapter()

        adapter.onItemClick = {
            val bundle = Bundle()
            bundle.putString("type", "${railway?.name}, ${railwaySection?.name}")

            if (it.type == Util.support) {
                bundle.putParcelable("support", ListItem(it.uid, it.name))
                findNavController().navigate(
                    R.id.action_screen_measurements_to_support,
                    bundle
                )
            } else {
                bundle.putParcelable("object", it)
                findNavController().navigate(
                    R.id.action_screen_measurements_to_station_peregon,
                    bundle
                )
            }
        }

        fetchData()

        binding = ScreenMeasurementsFragmentBinding.bind(view).apply {

            railway?.let { r ->
                railwaySection?.let { rs ->
                    selectedRailwayName.text = "${r.name}, ${rs.name}"
                }
            }

            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter

            LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                onItemClickImage = {
                    findNavController().navigate(R.id.action_screen_measurements_to_profile)
                }
                onItemClickButtonBack = {
                    findNavController().navigateUp()
                }
            }.bind(R.string.choose_object)


            edittext.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    FILTER_QUERY = s.toString()
                    fetchData()
                }
            })

            btnAll.setOnClickListener {
                FILTER_TYPE = null
                fetchData()
            }

            btnStation.setOnClickListener {
                FILTER_TYPE = Util.station
                fetchData()
            }

            btnPeregon.setOnClickListener {
                FILTER_TYPE = Util.peregon
                fetchData()
            }

            btnSupport.setOnClickListener {
                FILTER_TYPE = Util.support
                fetchData()
            }
        }
    }

    private fun fetchData() {
        railwaySection?.uid?.let { idParent ->
            viewModel.getAllStationPeregonsAndSupports(
                idParent,
                FILTER_TYPE,
                FILTER_QUERY
            )

            viewModel.allStationPeregonsAndSupports.observe(requireActivity()) { list ->
                adapter.submitList(list)
            }
        }
    }
}