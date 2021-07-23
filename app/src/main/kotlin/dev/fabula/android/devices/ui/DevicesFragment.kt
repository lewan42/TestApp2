package dev.fabula.android.devices.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.databinding.DevicesFragmentBinding
import dev.fabula.android.devices.adapter.DeviceAdapter
import dev.fabula.android.devices.di.DevicesComponent

class DevicesFragment : ViewModelFragment<DevicesFragmentBinding>(R.layout.devices_fragment) {

    private lateinit var adapter: DeviceAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DevicesComponent.create(context)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DeviceAdapter()

        adapter.submitList(
            mutableListOf(
                "1eeceeddeed", "qqdqedqdq2", "3qedeqdqd", "rwegegeg4", "5ergergerg"
            )
        )

        binding = DevicesFragmentBinding.bind(view).apply {

            recyclerView.adapter = adapter

            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}