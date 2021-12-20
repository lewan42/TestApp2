package dev.fabula.android.platform.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import dev.fabula.android.R
import dev.fabula.android.app.ui.*
import dev.fabula.android.app.util.Util
import dev.fabula.android.camera.CameraViewModel
import dev.fabula.android.databinding.PlatformFragmentBinding
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.dimensions.fence.model.DimensionsFenceTransit
import dev.fabula.android.list.items.model.ListItem
import dev.fabula.android.list.items.model.PassedClass
import dev.fabula.android.platform.di.PlatformComponent
import kotlinx.android.synthetic.main.platform_fragment.*

class PlatformFragment : ViewModelFragment<PlatformFragmentBinding>(R.layout.platform_fragment) {

    private val viewModelCamera: CameraViewModel by activityViewModel()
    private val viewModel: PlatformViewModule by activityViewModel()

    private val listItem get() = arguments?.getParcelable<ListItem>("listItem")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        PlatformComponent.create(context)
            .inject(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = PlatformFragmentBinding.bind(view).apply {

            viewModel.platformUpdate.event(viewLifecycleOwner) {
                if (it) showMessage(R.string.data_added_success)
                else showMessage(R.string.data_added_error)
            }

            viewModel.canopy.event(viewLifecycleOwner) { canopy ->
                val bundle = Bundle()
                bundle.putSerializable("typeClass", PassedClass.Canopy)
                bundle.putString("uid_canopy", canopy.uid)
                findNavController().navigate(R.id.action_platform_to_measurements_list, bundle)
            }

            viewModel.dimensionsFencesList.event(viewLifecycleOwner) { dimensionsFences ->
                val bundle = Bundle()
                bundle.putSerializable("typeClass", PassedClass.DimensionsFence)
                bundle.putString(
                    "dimension_fences_json_data",
                    Gson().toJson(
                        DimensionsFenceTransit(
                            dimensionsFences,
                            listItem!!.id,
                            getCountDimensionsFencesOfPlatform()
                        )
                    )
                )

                findNavController().navigate(R.id.action_platform_to_measurements_list, bundle)
            }


            listItem?.id?.let { uid ->
                viewModel.getPlatformById(uid)

                btnSave.setOnClickListener {
                    viewModel.update(
                        uid,
                        numberPathValue.text.toString(),
                        kmPathValue.text.toString(),
                        piketValue.text.toString(),
                        type1.text.toString(),
                        type2.text.toString(),
                        viewModelCamera.convertImage(photo1),
                        viewModelCamera.convertImage(photo2),
                        commentValue.text.toString(),
                        true
                    )
                }
            }

            val array1 = arrayOf(resources.getString(R.string.high), resources.getString(R.string.low))
            val adapter1: ArrayAdapter<String> =
                ArrayAdapter(requireContext(), android.R.layout.select_dialog_item, array1)
            type1.setAdapter(adapter1)
            type1.setText(array1[0], false)

            val array2 = arrayOf(resources.getString(R.string.coastal), resources.getString(R.string.insular))
            val adapter2: ArrayAdapter<String> =
                ArrayAdapter(requireContext(), android.R.layout.select_dialog_item, array2)
            type2.setAdapter(adapter2)
            type2.setText(array2[0], false)

            viewModel.platform.observe(viewLifecycleOwner) {
                type1.setText(it.type1, false)
                type2.setText(it.type2, false)

                numberPathValue.setText(it.way_number)
                kmPathValue.setText(it.km_way)
                piketValue.setText(it.picket)
                commentValue.setText(it.comment)
                photo1.setImageBitmap(viewModelCamera.convertImage(it.photo1))
                photo2.setImageBitmap(viewModelCamera.convertImage(it.photo2))
            }

            photo1.setOnClickListener {
                viewModelCamera.actionPhoto.postValue(Event(true))
            }

            photo2.setOnClickListener {
                viewModelCamera.actionPhoto2.postValue(Event(true))
            }

            viewModelCamera.takePhotoAction.event(viewLifecycleOwner) { bitmap ->
                bitmap.let {
                    viewModelCamera.insertBitmapOnImageView(requireContext(), bitmap, photo1)
                }
            }

            viewModelCamera.takePhotoAction2.event(viewLifecycleOwner) { bitmap ->
                bitmap.let {
                    viewModelCamera.insertBitmapOnImageView(requireContext(), bitmap, photo2)
                }
            }

            LayoutHeaderViewHolder(layoutHeader, requireContext()).apply {
                onItemClickImage = {
                    findNavController().navigate(R.id.action_platform_to_profile)
                }
                onItemClickButtonBack = {
                    findNavController().navigateUp()
                }
            }.bind("${listItem?.name}")

            btnMeasurements.setOnClickListener {
                val bundle = Bundle()
                listItem?.id?.let { it1 ->
                    bundle.putString("uid_platform", it1)
                }
                findNavController().navigate(R.id.action_platform_to_measurements_list, bundle)
            }

            btnReportPlatform.setOnClickListener {
                val bundle = Bundle()

                listItem?.id?.let { uidPlatform ->
                    bundle.putParcelable("listItem", ListItem(uidPlatform, resources.getString(R.string.platform)))
                }
                findNavController().navigate(R.id.action_platform_to_report, bundle)
            }

            btnReportCanopy.setOnClickListener {
                val bundle = Bundle()

                listItem?.id?.let { uidPlatform ->
                    bundle.putParcelable("listItem", ListItem(uidPlatform, resources.getString(R.string.canopy)))
                }
                findNavController().navigate(R.id.action_platform_to_report, bundle)
            }


            btnDimensionsCanopy.setOnClickListener {

                listItem?.id?.let { it1 ->
                    viewModel.getCanopyOfPlatform(it1)
                }
            }

            btnDimensionsFence.setOnClickListener {

                listItem?.id?.let { it1 ->
                    viewModel.getDimensionsFencesOfPlatform(
                        it1,
                        getCountDimensionsFencesOfPlatform()
                    )
                }
            }

            btnBridgeCrossing.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable("typeClass", PassedClass.BridgeCrossing)
                listItem?.id?.let { it1 -> bundle.putString("uid_platform", it1) }
                findNavController().navigate(
                    R.id.action_platform_to_list_items_bridges_crossing,
                    bundle
                )
            }

            btnSupport.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable("typeClass", PassedClass.Support)
                listItem?.id?.let { it1 -> bundle.putString("uid_platform", it1) }
                findNavController().navigate(R.id.action_platform_to_list_items_supports, bundle)
            }
        }
    }

    private fun getCountDimensionsFencesOfPlatform(): Int {
        return if (type2.text.toString() == resources.getString(R.string.coastal)) 2 else 4
    }
}