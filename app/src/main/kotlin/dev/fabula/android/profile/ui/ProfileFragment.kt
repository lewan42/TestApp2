package dev.fabula.android.profile.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import dev.fabula.android.BuildConfig
import dev.fabula.android.R
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.event
import dev.fabula.android.app.ui.showMessage
import dev.fabula.android.app.util.Util
import dev.fabula.android.bluetooth.ui.BluetoothViewModel
import dev.fabula.android.databinding.ProfileFragmentBinding
import dev.fabula.android.profile.di.ProfileComponent
import dev.fabula.android.synchronize.ui.SyncViewModule
import kotlinx.coroutines.runBlocking
import timber.log.Timber

class ProfileFragment : ViewModelFragment<ProfileFragmentBinding>(R.layout.profile_fragment) {

    private val viewModel: ProfileViewModel by activityViewModel()
    private val viewModelSync: SyncViewModule by activityViewModel()
    private val viewModelBLE: BluetoothViewModel by activityViewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ProfileComponent.create(context)
            .inject(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isNotSyncData.event(viewLifecycleOwner) {
            if (it) {
                Timber.e("Есть несохраненные данные")
                dialod()
            } else {
                Timber.e("Нет не несохраненных данных")
                findNavController().navigate(R.id.action_profile_to_auth)
            }
        }

        binding = ProfileFragmentBinding.bind(view).apply {

            tvVersion.text = tvVersion.text.toString() + " ${BuildConfig.VERSION_NAME}"

//            heightNorm.setText(Util.HEIGHT_NORM.toString())
//            widthNorm.setText(Util.WIDTH_NORM.toString())
//
//            btnSaveNorm.setOnClickListener {
//                Util.HEIGHT_NORM = heightNorm.text.toString().toInt()
//                Util.WIDTH_NORM = widthNorm.text.toString().toInt()
//                Toast.makeText(requireContext(), "Нормы сохранены", Toast.LENGTH_SHORT).show()
//            }

            viewModelBLE.device.observe(viewLifecycleOwner) {
                tvConnectedDeviceName.text = it.displayName
            }

            btnExit.setOnClickListener {
                viewModel.checkNotSyncData()
            }

            btnAddPhoto.setOnClickListener {
                findNavController().navigate(R.id.action_profile_to_union_measurement_list)
            }

//            btnCalibration.setOnClickListener {
//                findNavController().navigate(R.id.action_profile_to_calibration)
//            }

//            btnCreateReport.setOnClickListener {
//                findNavController().navigate(R.id.action_profile_to_report)
//            }

            tvEmail.text = viewModel.getEmailName().toString()

            btnBluetoothBosch.setOnClickListener {
                findNavController().navigate(R.id.action_profile_to_bluetooth)
            }

            viewModelSync.sync.event(viewLifecycleOwner) {
                progressSync.visibility = View.INVISIBLE
                if (it) showMessage(R.string.data_added_success)
                else showMessage(R.string.data_added_error)
            }

            btnSync.setOnClickListener {
                progressSync.visibility = View.VISIBLE
                viewModelSync.sync()
            }

            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun dialod() {
        val builder1: AlertDialog.Builder = AlertDialog.Builder(context)
        builder1.setMessage("У вас есть не синхронизированные данные. В случае выхода из программы все не синхронизированные данные удалятся. Вы точно хотите выйти?")
        builder1.setCancelable(true)

        builder1.setPositiveButton("Да") { dialog, _ ->
            runBlocking {
                viewModel.exit()
                dialog.cancel()
                findNavController().navigate(R.id.action_profile_to_auth)
            }
        }

        builder1.setNegativeButton("Нет") { dialog, _ ->
            run { dialog.cancel() }
        }

        val alert11: AlertDialog = builder1.create()
        alert11.show()
    }
}