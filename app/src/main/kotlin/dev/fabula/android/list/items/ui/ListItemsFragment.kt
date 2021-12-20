package dev.fabula.android.list.items.ui

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.LayoutHeaderViewHolder
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.event
import dev.fabula.android.databinding.ListItemsFragmentBinding
import dev.fabula.android.list.items.adapter.ListItemsAdapter
import dev.fabula.android.list.items.di.ListItemsComponent
import dev.fabula.android.list.items.model.ListItem
import dev.fabula.android.list.items.model.PassedClass
import timber.log.Timber

class ListItemsFragment :
    ViewModelFragment<ListItemsFragmentBinding>(R.layout.list_items_fragment) {

    private val viewModel: ListItemsViewModel by activityViewModel()

    private lateinit var adapter: ListItemsAdapter

    private val typeClass get() = arguments?.getSerializable("typeClass")
    private val uidStation get() = arguments?.getString("uid_station")
    private val uidPlatform get() = arguments?.getString("uid_platform")
    private val uidBridge get() = arguments?.getString("uid_bridge")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ListItemsComponent.create(context)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (typeClass != null)
            adapter = when (typeClass) {
                PassedClass.Platform -> ListItemsAdapter(resources.getString(R.string.platform))
                PassedClass.BridgeCrossing -> ListItemsAdapter(resources.getString(R.string.bridge_cross))
                PassedClass.Support -> ListItemsAdapter(resources.getString(R.string.support))
                else -> ListItemsAdapter("")
            }

        adapter.onItemClick = { listItem ->
            val bundle = Bundle()
            bundle.putParcelable("listItem", listItem)
            typeClass?.let { typeClass ->

                when (typeClass) {
                    PassedClass.Platform -> {
                        Timber.e("adapter.onItemClick PassedClass.Platform")
                        findNavController().navigate(
                            R.id.action_list_items_to_platform,
                            bundle
                        )
                    }

                    PassedClass.BridgeCrossing -> {
                        Timber.e("adapter.onItemClick PassedClass.BridgeCrossing")
                        bundle.putParcelable("bridge", listItem)
                        findNavController().navigate(
                            R.id.action_list_items_to_bridge_crossing,
                            bundle
                        )
                    }

                    //not use!?
                    PassedClass.DimensionsFence -> {
                        Timber.e("adapter.onItemClick PassedClass.DimensionsFence")
                        uidPlatform?.let {
                            bundle.putString("uid_platform", it)
                        }
                        bundle.putString("uid_dimension", listItem.id)
                        findNavController().navigate(
                            R.id.action_list_items_to_dimensions_fence,
                            bundle
                        )
                    }

                    PassedClass.Support -> {
                        Timber.e("adapter.onItemClick PassedClass.Support")
                        bundle.putParcelable("support", listItem)
                        findNavController().navigate(
                            R.id.action_list_items_to_support,
                            bundle
                        )
                    }
                }
            }
        }

        binding = ListItemsFragmentBinding.bind(view).apply {

            typeClass?.let { typeClass ->
                uidStation?.let { uid ->
                    when (typeClass) {
                        PassedClass.Platform -> {
                            btnAdd.visibility = View.GONE
                            viewModel.fetchPlatformsOfRailwaySection(uid)
                                .observe(requireActivity()) { list ->
                                    list?.let { listPlatforms ->
                                        adapter.submitList(listPlatforms)
                                    }
                                }
                        }
                        PassedClass.Support -> {
                            viewModel.fetchSupportOfRailwaySection(uid)
                                .observe(requireActivity()) { list ->
                                    list?.let { listSupports ->
                                        adapter.submitList(listSupports)
                                    }
                                }

                            btnAdd.setOnClickListener {
                                val bundle = Bundle()
                                bundle.putString("station_uid", uid)
                                findNavController().navigate(
                                    R.id.action_list_items_to_support,
                                    bundle
                                )
                            }
                        }
                    }
                }

                uidPlatform?.let { uidPlatform ->
                    when (typeClass) {
                        PassedClass.DimensionsFence -> {
                            Timber.e("uidPlatform PassedClass.DimensionsFence")
                            viewModel.fetchDimensionFenceOfPlatform(uidPlatform)
                                .observe(requireActivity()) { list ->
                                    list?.let { listDimensions ->
                                        adapter.submitList(listDimensions)
                                    }
                                }
                        }
                        PassedClass.BridgeCrossing -> {
                            Timber.e("uidPlatform PassedClass.BridgeCrossing")
                            viewModel.fetchBridgesOfPlatform(uidPlatform)
                                .observe(requireActivity()) { list ->
                                    list?.let { listBridges ->
                                        adapter.submitList(listBridges)
                                    }
                                }
                            btnAdd.setOnClickListener {
                                val bundle = Bundle()
                                bundle.putString("platform_uid", uidPlatform)
                                findNavController().navigate(
                                    R.id.action_list_items_to_bridge_crossing,
                                    bundle
                                )
                            }
                        }

                        PassedClass.Support -> {
                            Timber.e("uidPlatform PassedClass.Support")
                            viewModel.fetchSupportsOfPlatform(uidPlatform)
                                .observe(requireActivity()) { list ->
                                    list?.let { listSupports ->
                                        adapter.submitList(listSupports)
                                    }
                                }
                            btnAdd.setOnClickListener {
                                val bundle = Bundle()
                                bundle.putString("platform_uid", uidPlatform)
                                findNavController().navigate(
                                    R.id.action_list_items_to_support,
                                    bundle
                                )
                            }
                        }
                    }
                }

                uidBridge?.let { uidBridge ->
                    viewModel.fetchSupportsOfBridge(uidBridge)
                        .observe(requireActivity()) { list ->
                            list?.let { listSupports ->
                                adapter.submitList(listSupports)
                            }
                        }

                    btnAdd.setOnClickListener {
                        val bundle = Bundle()
                        bundle.putString("bridge_uid", uidBridge)
                        findNavController().navigate(
                            R.id.action_list_items_to_support,
                            bundle
                        )
                    }
                }

                LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                    onItemClickImage = {
                        findNavController().navigate(R.id.action_list_items_to_profile)
                    }
                    onItemClickButtonBack = {
                        findNavController().navigateUp()
                    }
                }.bind(convertTypeClassToName(typeClass.toString()))
            }

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
                    adapter.filter(s)
                }
            })

            recyclerView.adapter = adapter
        }
    }

    private fun convertTypeClassToName(typeClass: String): String {
        return when (typeClass) {
            "Platform" -> resources.getString(R.string.platforms)
            "BridgeCrossing" -> resources.getString(R.string.bridges_crossing)
            "Support" -> resources.getString(R.string.supports)
            "DimensionsFence" -> resources.getString(R.string.dimensions_of_the_end_fence)
            else -> ""
        }
    }
}