package dev.fabula.android.profile.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.BuildConfig
import dev.fabula.android.R
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.event
import dev.fabula.android.app.ui.showMessage
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

            viewModelBLE.device.observe(viewLifecycleOwner) {
                tvConnectedDeviceName.text = it.displayName
            }

            btnExit.setOnClickListener {
                viewModel.checkNotSyncData()
            }

            btnAddPhoto.setOnClickListener {
                findNavController().navigate(R.id.action_profile_to_union_measurement_list)
            }

            btnLab.setOnClickListener {
                findNavController().navigate(R.id.action_profile_to_lab)
            }


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
        builder1.setMessage("")
        builder1.setCancelable(true)

        builder1.setPositiveButton(resources.getString(R.string.yes)) { dialog, _ ->
            runBlocking {
                viewModel.exit()
                dialog.cancel()
                findNavController().navigate(R.id.action_profile_to_auth)
            }
        }

        builder1.setNegativeButton(resources.getString(R.string.no)) { dialog, _ ->
            run { dialog.cancel() }
        }

        val alert11: AlertDialog = builder1.create()
        alert11.show()
    }
}