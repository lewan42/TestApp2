package dev.fabula.android.synchronize.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.event
import dev.fabula.android.app.ui.showMessage
import dev.fabula.android.databinding.SyncFragmentBinding
import dev.fabula.android.synchronize.di.SyncComponent

class SyncFragment : ViewModelFragment<SyncFragmentBinding>(R.layout.sync_fragment) {

    private val viewModel: SyncViewModule by activityViewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        SyncComponent.create(context).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.sync.event(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(R.id.action_sync_to_railway)
            } else {
                showMessage(R.string.data_added_error)
                findNavController().navigate(R.id.action_sync_to_railway)
            }
        }

        binding = SyncFragmentBinding.bind(view).apply {
            viewModel.sync()
        }
    }
}