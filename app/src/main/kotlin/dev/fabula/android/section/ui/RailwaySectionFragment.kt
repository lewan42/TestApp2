package dev.fabula.android.section.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.LayoutHeaderViewHolder
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.databinding.RailwaySectionFragmentBinding
import dev.fabula.android.railway.model.Railway
import dev.fabula.android.section.adapter.RailwaySectionAdapter
import dev.fabula.android.section.di.RailwaySectionComponent

class RailwaySectionFragment :
    ViewModelFragment<RailwaySectionFragmentBinding>(R.layout.railway_section_fragment) {

    private lateinit var adapter: RailwaySectionAdapter
    private val viewModel: RailwaySectionViewModel by activityViewModel()

    private val railway get() = arguments?.getParcelable<Railway>("railway")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        RailwaySectionComponent.create(context)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RailwaySectionAdapter()

        adapter.onItemClick = {
            val bundle = Bundle()
            bundle.putParcelable("railway", railway)
            bundle.putParcelable("railwaySection", it)
            findNavController().navigate(R.id.action_railway_section_toscreen_measurements, bundle)
        }

        viewModel.railwaySections.observe(requireActivity()) { railwaySection ->
            railwaySection.let { adapter.submitList(it) }
        }

        binding = RailwaySectionFragmentBinding.bind(view).apply {
            recyclerView.adapter = adapter

            railway?.let {
                selectedRailwayName.text = it.name
                viewModel.getRailwaySections(it.uid)
            }

            LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                onItemClickImage = {
                    findNavController().navigate(R.id.action_railway_section_to_profile)
                }
                onItemClickButtonBack = {
                    findNavController().navigateUp()
                }
            }.bind(R.string.choose_railway_section)
        }
    }
}