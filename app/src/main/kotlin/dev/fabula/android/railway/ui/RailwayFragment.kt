package dev.fabula.android.railway.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.LayoutHeaderViewHolder
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.databinding.RailwayFragmentBinding
import dev.fabula.android.railway.adapter.RailwayAdapter
import dev.fabula.android.railway.di.RailwayComponent

class RailwayFragment : ViewModelFragment<RailwayFragmentBinding>(R.layout.railway_fragment) {

    private lateinit var adapter: RailwayAdapter

    private val viewModel: RailwayViewModel by activityViewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        RailwayComponent.create(context)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RailwayAdapter()
        adapter.onItemClick = {
            val bundle = Bundle()
            bundle.putParcelable("railway", it)
            findNavController().navigate(R.id.action_railway_to_railway_section, bundle)
        }

        viewModel.allRailways.observe(requireActivity()) { railway ->
            railway.let {
                adapter.submitList(it)
            }
        }

        binding = RailwayFragmentBinding.bind(view).apply {
            recyclerView.adapter = adapter

            LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                onItemClickImage = {
                    findNavController().navigate(R.id.action_railway_to_profile)
                }
            }.bind(R.string.choose_railway)
        }
    }
}