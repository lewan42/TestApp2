package dev.fabula.android.bridge.crossing.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.LayoutHeaderViewHolder
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.event
import dev.fabula.android.app.ui.showMessage
import dev.fabula.android.bridge.crossing.di.BridgeComponent
import dev.fabula.android.databinding.BridgeCrossingFragmentBinding
import dev.fabula.android.list.items.model.ListItem
import dev.fabula.android.list.items.model.PassedClass
import timber.log.Timber

class BridgeCrossingFragment :
    ViewModelFragment<BridgeCrossingFragmentBinding>(R.layout.bridge_crossing_fragment) {

    private val bridge
        get() = arguments?.getParcelable<ListItem>(
            "bridge"
        )

    private val uidPlatformForCreateBridge get() = arguments?.getString("platform_uid")

    private var createdUidBridge: String? = null

    private val viewModel: BridgeViewModule by activityViewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        BridgeComponent.create(context).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = BridgeCrossingFragmentBinding.bind(view).apply {

            viewModel.createBridge.event(viewLifecycleOwner) {
                it?.let {
                    showMessage(R.string.create_bridge_success)
                    createdUidBridge = it
                }
            }

            uidPlatformForCreateBridge?.let { uidPlatform ->
                Timber.e("uidPlatformForCreateBridge: $createdUidBridge")

                LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                    onItemClickImage = {
                        findNavController().navigate(R.id.action_bridge_crossing_to_profile)
                    }
                    onItemClickButtonBack = {
                        findNavController().navigateUp()
                    }
                }.bind("Создание мостового перехода")

                btnDimensionsDown.setOnClickListener {

                    if (createdUidBridge == null) {
                        showMessage(R.string.button_click_bridge)
                        return@setOnClickListener
                    }

                    val bundle = Bundle()
                    bundle.putString("uid_bridge", createdUidBridge)

                    findNavController().navigate(
                        R.id.action_bridge_crossing_to_measurements_list,
                        bundle
                    )
                }

                btnSupports.setOnClickListener {

                    if (createdUidBridge == null) {
                        showMessage(R.string.button_click_bridge)
                        return@setOnClickListener
                    }

                    val bundle = Bundle()
                    bundle.putString("uid_bridge", createdUidBridge)
                    bundle.putSerializable("typeClass", PassedClass.Support)
                    findNavController().navigate(
                        R.id.action_bridge_crossing_to_list_items_supports,
                        bundle
                    )
                }

                //создаем мост только если createdUidBridge == null
                btnSave.setOnClickListener {
                    if (createdUidBridge == null)
                        viewModel.createBridge(uidPlatform)
                    else showMessage(R.string.create_bridge_success)
                }
            }

            bridge?.let { bridge ->
                Timber.e("bridge")
                LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                    onItemClickImage = {
                        findNavController().navigate(R.id.action_bridge_crossing_to_profile)
                    }
                    onItemClickButtonBack = {
                        findNavController().navigateUp()
                    }
                }.bind(bridge.name)


                btnDimensionsDown.setOnClickListener {

                    val bundle = Bundle()
                    bundle.putString("uid_bridge", bridge.id)
                    findNavController().navigate(
                        R.id.action_bridge_crossing_to_measurements_list,
                        bundle
                    )
                }

                btnSupports.setOnClickListener {

                    val bundle = Bundle()
                    bundle.putString("uid_bridge", bridge.id)
                    bundle.putSerializable("typeClass", PassedClass.Support)
                    findNavController().navigate(
                        R.id.action_bridge_crossing_to_list_items_supports,
                        bundle
                    )
                }

                btnSave.setOnClickListener {
                    showMessage(R.string.create_support_success)
                    findNavController().navigateUp()
                }
            }
        }
    }
}