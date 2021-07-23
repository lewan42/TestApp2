package dev.fabula.android.support.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.*
import dev.fabula.android.camera.CameraViewModel
import dev.fabula.android.databinding.SupportFragmentBinding
import dev.fabula.android.support.di.SupportComponent
import timber.log.Timber

class SupportFragment : ViewModelFragment<SupportFragmentBinding>(R.layout.support_fragment) {

    private val viewModel: SupportViewModule by activityViewModel()
    private val viewModelCamera: CameraViewModel by activityViewModel()

    private val support
        get() = arguments?.getParcelable<dev.fabula.android.list.items.model.ListItem>(
            "support"
        )

    private val uidPlatformForCreateSupport get() = arguments?.getString("platform_uid")
    private val uidBridgeForCreateSupport get() = arguments?.getString("bridge_uid")
    private val uidStationForCreateSupport get() = arguments?.getString("station_uid")

    private var createdUidSupport: String? = null

    private val bundle = Bundle()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        SupportComponent.create(context)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = SupportFragmentBinding.bind(view).apply {

            //В сущ опоре заполням поля данными
            viewModel.support.event(viewLifecycleOwner) { support ->
                support.let {
                    number.setText(support.number)
                    kmPath.setText(support.km_way)
                    wayNumber.setText(support.way_number)
                    picket.setText(support.picket)
                    photo1.setImageBitmap(viewModelCamera.convertImage(support.photo1))
                    photo2.setImageBitmap(viewModelCamera.convertImage(support.photo2))
                }
            }

            viewModel.updateSupport.event(viewLifecycleOwner) {
                if (it)
                    showMessage(R.string.data_added_success)
                else showMessage(R.string.data_added_error)
            }

            viewModel.measurement.event(viewLifecycleOwner) { measurement ->
                bundle.remove("uid")
                measurement?.let {
                    bundle.putString("uid", measurement.uid)
                }
                Timber.i("viewModel.measurement: ${bundle.toString()}")
                findNavController().navigate(R.id.action_support_to_create_measurement, bundle)
            }

            viewModel.createContactWireForHeight.event(viewLifecycleOwner) {
                if (it != null) {
                    Timber.i("viewModel.createContactWireForHeight: ${it}")
                    bundle.putString("uid_contact_wire", it.uid)
                    bundle.remove("uid_carrier_wire")
                    bundle.putString("uid_measurement_type", it.type_height_wire_uid)
                    viewModel.getMeasurementByParentContactWire(it.uid, it.type_height_wire_uid)
                }
            }

            viewModel.contactWireForZigzag.event(viewLifecycleOwner) {
                if (it != null) {
                    Timber.i("viewModel.contactWireForZigzag.event: ${it}")
                    bundle.putString("uid_contact_wire", it.uid)
                    bundle.remove("uid_carrier_wire")
                    bundle.putString("uid_measurement_type", it.type_zigzag_wire_uid)
                    viewModel.getMeasurementByParentContactWire(it.uid, it.type_zigzag_wire_uid)
                }
            }

            viewModel.carrierWireForHeight.event(viewLifecycleOwner) {
                if (it != null) {
                    Timber.i("viewModel.carrierWireForHeight.event: ${it}")
                    bundle.putString("uid_carrier_wire", it.uid)
                    bundle.remove("uid_contact_wire")
                    bundle.putString("uid_measurement_type", it.type_height_wire_uid)
                    Timber.i("carrierWireForHeight bundle: $bundle")
                    viewModel.getMeasurementByParentCarrierWire(it.uid, it.type_height_wire_uid)
                }
            }

            viewModel.carrierWireForZigzag.event(viewLifecycleOwner) {
                if (it != null) {
                    Timber.i("viewModel.carrierWireForZigzag.event: $it $bundle")
                    bundle.remove("uid_contact_wire")
                    bundle.putString("uid_carrier_wire", it.uid)
                    bundle.putString("uid_measurement_type", it.type_zigzag_wire_uid)
                    Timber.i("carrierWireForZigzag bundle 2: $bundle")
                    viewModel.getMeasurementByParentCarrierWire(it.uid, it.type_zigzag_wire_uid)
                }
            }

            viewModel.createIfNotExist.event(viewLifecycleOwner) {
                if (!it) {
                    showMessage(R.string.error_wires)
                    findNavController().navigateUp()
                }
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

            support?.let {
                LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                    onItemClickImage = {
                        findNavController().navigate(R.id.action_support_to_profile)
                    }
                    onItemClickButtonBack = {
                        findNavController().navigateUp()
                    }
                }.bind("Опора ${it.name}")

                viewModel.getSupportById(it.id)

                btnHeightContactWire.setOnClickListener { v ->
                    Timber.e("getContactWireForHeightBySupport:")
                    viewModel.getContactWireForHeightBySupport(it.id)
                }

                btnZigzagContactWire.setOnClickListener { v ->
                    Timber.e("getContactWireForZigzagBySupport:")
                    viewModel.getContactWireForZigzagBySupport(it.id)
                }

                btnHeightCarrierWire.setOnClickListener { v ->
                    Timber.e("getCarrierWireForHeightBySupport:")
                    viewModel.getCarrierWireForHeightBySupport(it.id)
                }

                btnZigzagCarrierWire.setOnClickListener { v ->
                    Timber.e("getCarrierWireForHeightBySupport:")
                    viewModel.getCarrierWireForZigzagBySupport(it.id)
                }

                btnSave.setOnClickListener { v ->
                    if (number.text.isNullOrEmpty() || kmPath.text.isNullOrEmpty() || wayNumber.text.isNullOrEmpty() || picket.text.isNullOrEmpty()) {
                        showMessage(R.string.fill_in_all_fields)
                        return@setOnClickListener

                    }
                    viewModel.updateSupport(
                        it.id,
                        number.text.toString(),
                        kmPath.text.toString(),
                        wayNumber.text.toString(),
                        picket.text.toString(),
                        "",
                        viewModelCamera.convertImage(photo1),
                        viewModelCamera.convertImage(photo2)
                    )
                }
            }

            uidStationForCreateSupport?.let {

                LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                    onItemClickImage = {
                        findNavController().navigate(R.id.action_support_to_profile)
                    }
                    onItemClickButtonBack = {
                        findNavController().navigateUp()
                    }
                }.bind("Создание опоры")

                btnHeightContactWire.setOnClickListener { v ->
                    Timber.e("getContactWireForHeightBySupport 11:")
                    if (createdUidSupport == null) {
                        showMessage(R.string.button_click_support)
                        return@setOnClickListener
                    }

                    createdUidSupport?.let {
                        viewModel.getContactWireForHeightBySupport(it)
                    }
                }

                btnZigzagContactWire.setOnClickListener { v ->
                    Timber.e("getContactWireForZigzagBySupport: ")
                    if (createdUidSupport == null) {
                        showMessage(R.string.button_click_support)
                        return@setOnClickListener
                    }

                    createdUidSupport?.let {
                        viewModel.getContactWireForZigzagBySupport(it)
                    }
                }

                btnHeightCarrierWire.setOnClickListener { v ->
                    Timber.e("getCarrierWireForHeightBySupport: ")

                    if (createdUidSupport == null) {
                        showMessage(R.string.button_click_support)
                        return@setOnClickListener
                    }

                    createdUidSupport?.let {
                        viewModel.getCarrierWireForHeightBySupport(it)
                    }
                }

                btnZigzagCarrierWire.setOnClickListener { v ->
                    Timber.e("getCarrierWireForHeightBySupport:")
                    if (createdUidSupport == null) {
                        showMessage(R.string.button_click_support)
                        return@setOnClickListener
                    }

                    createdUidSupport?.let {
                        viewModel.getCarrierWireForZigzagBySupport(it)
                    }
                }

                btnSave.setOnClickListener { v ->
                    if (number.text.isNullOrEmpty() || kmPath.text.isNullOrEmpty() || wayNumber.text.isNullOrEmpty() || picket.text.isNullOrEmpty()) {
                        showMessage(R.string.fill_in_all_fields)
                        return@setOnClickListener

                    } else if (createdUidSupport != null) {
                        viewModel.updateSupport(
                            createdUidSupport!!,
                            number.text.toString(),
                            kmPath.text.toString(),
                            wayNumber.text.toString(),
                            picket.text.toString(),
                            "",
                            viewModelCamera.convertImage(photo1),
                            viewModelCamera.convertImage(photo2)
                        )
                    } else {
                        viewModel.createSupport(
                            it,
                            "station",
                            number.text.toString(),
                            kmPath.text.toString(),
                            wayNumber.text.toString(),
                            picket.text.toString(),
                            viewModelCamera.convertImage(photo1),
                            viewModelCamera.convertImage(photo2)
                        )
                    }
                }

                viewModel.uidCreatedSupportOfPlatform.event(viewLifecycleOwner) {
                    it?.let {
                        createdUidSupport = it
                        showMessage(R.string.create_support_success)
                    }
                }
            }

            uidBridgeForCreateSupport?.let {

                LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                    onItemClickImage = {
                        findNavController().navigate(R.id.action_support_to_profile)
                    }
                    onItemClickButtonBack = {
                        findNavController().navigateUp()
                    }
                }.bind("Создание опоры")

                btnHeightContactWire.setOnClickListener { v ->
                    Timber.e("getContactWireForHeightBySupport 11:")
                    if (createdUidSupport == null) {
                        showMessage(R.string.button_click_support)
                        return@setOnClickListener
                    }

                    createdUidSupport?.let {
                        viewModel.getContactWireForHeightBySupport(it)
                    }
                }

                btnZigzagContactWire.setOnClickListener { v ->
                    Timber.e("getContactWireForZigzagBySupport: ")
                    if (createdUidSupport == null) {
                        showMessage(R.string.button_click_support)
                        return@setOnClickListener
                    }

                    createdUidSupport?.let {
                        viewModel.getContactWireForZigzagBySupport(it)
                    }
                }

                btnHeightCarrierWire.setOnClickListener { v ->
                    Timber.e("getCarrierWireForHeightBySupport: ")

                    if (createdUidSupport == null) {
                        showMessage(R.string.button_click_support)
                        return@setOnClickListener
                    }

                    createdUidSupport?.let {
                        viewModel.getCarrierWireForHeightBySupport(it)
                    }
                }

                btnZigzagCarrierWire.setOnClickListener { v ->
                    Timber.e("getCarrierWireForHeightBySupport:")
                    if (createdUidSupport == null) {
                        showMessage(R.string.button_click_support)
                        return@setOnClickListener
                    }

                    createdUidSupport?.let {
                        viewModel.getCarrierWireForZigzagBySupport(it)
                    }
                }

                btnSave.setOnClickListener { v ->
                    if (number.text.isNullOrEmpty() || kmPath.text.isNullOrEmpty() || wayNumber.text.isNullOrEmpty() || picket.text.isNullOrEmpty()) {
                        showMessage(R.string.fill_in_all_fields)
                        return@setOnClickListener

                    } else if (createdUidSupport != null) {
                        viewModel.updateSupport(
                            createdUidSupport!!,
                            number.text.toString(),
                            kmPath.text.toString(),
                            wayNumber.text.toString(),
                            picket.text.toString(),
                            "",
                            viewModelCamera.convertImage(photo1),
                            viewModelCamera.convertImage(photo2)
                        )
                    } else {
                        viewModel.createSupport(
                            it,
                            "bridge",
                            number.text.toString(),
                            kmPath.text.toString(),
                            wayNumber.text.toString(),
                            picket.text.toString(),
                            viewModelCamera.convertImage(photo1),
                            viewModelCamera.convertImage(photo2)
                        )
                    }
                }

                viewModel.uidCreatedSupportOfPlatform.event(viewLifecycleOwner) {
                    it?.let {
                        createdUidSupport = it
                        showMessage(R.string.create_support_success)
                    }
                }
            }

            uidPlatformForCreateSupport?.let {

                LayoutHeaderViewHolder(layoutHeader,requireContext()).apply {
                    onItemClickImage = {
                        findNavController().navigate(R.id.action_support_to_profile)
                    }
                    onItemClickButtonBack = {
                        findNavController().navigateUp()
                    }
                }.bind("Создание опоры")

                btnHeightContactWire.setOnClickListener { v ->
                    Timber.e("getContactWireForHeightBySupport 11:")
                    if (createdUidSupport == null) {
                        showMessage(R.string.button_click_support)
                        return@setOnClickListener
                    }

                    createdUidSupport?.let {
                        viewModel.getContactWireForHeightBySupport(it)
                    }
                }

                btnZigzagContactWire.setOnClickListener { v ->
                    Timber.e("getContactWireForZigzagBySupport: ")
                    if (createdUidSupport == null) {
                        showMessage(R.string.button_click_support)
                        return@setOnClickListener
                    }

                    createdUidSupport?.let {
                        viewModel.getContactWireForZigzagBySupport(it)
                    }
                }

                btnHeightCarrierWire.setOnClickListener { v ->
                    Timber.e("getCarrierWireForHeightBySupport: ")

                    if (createdUidSupport == null) {
                        showMessage(R.string.button_click_support)
                        return@setOnClickListener
                    }

                    createdUidSupport?.let {
                        viewModel.getCarrierWireForHeightBySupport(it)
                    }
                }

                btnZigzagCarrierWire.setOnClickListener { v ->
                    Timber.e("getCarrierWireForHeightBySupport:")
                    if (createdUidSupport == null) {
                        showMessage(R.string.button_click_support)
                        return@setOnClickListener
                    }

                    createdUidSupport?.let {
                        viewModel.getCarrierWireForZigzagBySupport(it)
                    }
                }

                btnSave.setOnClickListener { v ->
                    if (number.text.isNullOrEmpty() || kmPath.text.isNullOrEmpty() || wayNumber.text.isNullOrEmpty() || picket.text.isNullOrEmpty()) {
                        showMessage(R.string.fill_in_all_fields)
                        return@setOnClickListener

                    } else if (createdUidSupport != null) {
                        viewModel.updateSupport(
                            createdUidSupport!!,
                            number.text.toString(),
                            kmPath.text.toString(),
                            wayNumber.text.toString(),
                            picket.text.toString(),
                            "",
                            viewModelCamera.convertImage(photo1),
                            viewModelCamera.convertImage(photo2)
                        )
                    } else {
                        viewModel.createSupport(
                            it,
                            "platform",
                            number.text.toString(),
                            kmPath.text.toString(),
                            wayNumber.text.toString(),
                            picket.text.toString(),
                            viewModelCamera.convertImage(photo1),
                            viewModelCamera.convertImage(photo2)
                        )
                    }
                }

                viewModel.uidCreatedSupportOfPlatform.event(viewLifecycleOwner) {
                    it?.let {
                        createdUidSupport = it
                        showMessage(R.string.create_support_success)
                    }
                }
            }
        }
    }
}