package dev.fabula.android.station.peregon.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import dev.fabula.android.R
import dev.fabula.android.app.ui.*
import dev.fabula.android.camera.CameraViewModel
import dev.fabula.android.databinding.StationPeregonFragmentBinding
import dev.fabula.android.list.items.model.PassedClass
import dev.fabula.android.screen.measurements.model.ListItem
import dev.fabula.android.station.peregon.di.StationPeregonComponent
import timber.log.Timber
import java.lang.Exception
import java.util.*

class StationPeregonFragment :
    ViewModelFragment<StationPeregonFragmentBinding>(R.layout.station_peregon_fragment) {

    private val type get() = arguments?.getString("type")
    private val obj get() = arguments?.getParcelable<ListItem>("object")
    private val viewModel: StationPeregonViewModule by activityViewModel()
    private val viewModelCamera: CameraViewModel by activityViewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        StationPeregonComponent.create(context)
            .inject(this)
    }

    @SuppressLint("SetTextI18n")
    private fun initBtn(button: Button, text: String, count: Int) {
        button.visibility = if (count <= 0) {
            View.GONE
            //View.VISIBLE
        } else {
            button.text = "$text: $count"
            View.VISIBLE
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.stationUpdate.event(viewLifecycleOwner) {
            it.let {
                if (it) showMessage(R.string.data_added_success)
                else showMessage(R.string.data_added_error)
            }
        }

        binding = StationPeregonFragmentBinding.bind(view).apply {
            obj?.let { listItem ->
                nameType.text = "Тип: ${listItem.type}"

                viewModel.stationPeregon(listItem.uid)
                viewModel.station.observe(requireActivity()) { station ->
                    station?.let { it ->
                        initBtn(
                            btnPlatform,
                            view.context.getString(R.string.platform),
                            station.platform_count
                        )

                        initBtn(
                            btnSupport,
                            view.context.getString(R.string.support),
                            station.opora_count
                        )

                        commentValue.setText(it.comment)

                        it.photo1?.let { strImage ->
                            photo1.setImageBitmap(viewModelCamera.convertImage(strImage))
                        }

                        it.photo2?.let { strImage ->
                            photo2.setImageBitmap(viewModelCamera.convertImage(strImage))
                        }
                    }
                }

                btnPlatform.setOnClickListener {
                    jump(
                        PassedClass.Platform,
                        R.id.action_station_peregon_to_list_items_platform,
                        listItem.uid
                    )
                }

                btnBridge.setOnClickListener {
                    jump(
                        PassedClass.BridgeCrossing,
                        R.id.action_station_peregon_to_list_items_bridge_crossing,
                        listItem.uid
                    )
                }

                btnSupport.setOnClickListener {
                    jump(
                        PassedClass.Support,
                        R.id.action_station_peregon_to_list_items_support,
                        listItem.uid
                    )
                }

                btnSave.setOnClickListener {
                    viewModel.stationPeregonUpdate(
                        listItem.uid,
                        commentValue.text.toString(),
                        viewModelCamera.convertImage(photo1),
                        viewModelCamera.convertImage(photo2)
                    )
                }
            }

            photo1.setOnClickListener {
                viewModelCamera.actionPhoto.postValue(Event(true))
            }

            photo2.setOnClickListener {
                viewModelCamera.actionPhoto2.postValue(Event(true))
            }

            viewModelCamera.takePhotoAction.event(viewLifecycleOwner) { bitmap ->
                Timber.e("Station peregon viewModelCamera.takePhotoAction")
                bitmap.let {
                    viewModelCamera.insertBitmapOnImageView(requireContext(), bitmap, photo1)
                }
            }

            viewModelCamera.takePhotoAction2.event(viewLifecycleOwner) { bitmap ->
                bitmap.let {
                    viewModelCamera.insertBitmapOnImageView(requireContext(), bitmap, photo2)
                }
            }

            LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                onItemClickImage = {
                    findNavController().navigate(R.id.action_station_peregon_to_profile)
                }
                onItemClickButtonBack = {
                    findNavController().navigateUp()
                }
            }.bind(type)
        }
    }

    private fun jump(typeClass: PassedClass, idLayout: Int, uid: String) {
        val bundle = Bundle()
        bundle.putSerializable("typeClass", typeClass)
        bundle.putString("uid_station", uid)
        findNavController().navigate(
            idLayout,
            bundle
        )
    }
}