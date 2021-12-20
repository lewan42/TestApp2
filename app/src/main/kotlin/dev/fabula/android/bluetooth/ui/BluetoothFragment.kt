package dev.fabula.android.bluetooth.ui

import android.Manifest
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.app.AlertDialog
import android.content.*
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.LayoutHeaderViewHolder
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.setTitle
import dev.fabula.android.app.util.Util
import dev.fabula.android.bluetooth.GLMDeviceController
import dev.fabula.android.bluetooth.adapter.BluetoothMyAdapter
import dev.fabula.android.bluetooth.bluetooth.BLEService
import dev.fabula.android.bluetooth.bluetooth.MTBluetoothDevice
import dev.fabula.android.bluetooth.di.BluetoothComponent
import dev.fabula.android.bluetooth.exc.BluetoothNotSupportedException
import dev.fabula.android.databinding.BluetoothFragmentBinding
import dev.fabula.android.module.mtprotocol.glm100C.connection.MtAsyncConnection
import kotlinx.android.synthetic.main.layout_header.*
import timber.log.Timber
import java.util.*

class BluetoothFragment : ViewModelFragment<BluetoothFragmentBinding>(R.layout.bluetooth_fragment) {

    private val viewModel: BluetoothViewModel by activityViewModel()

    val REQUEST_CODE_ASK_PERMISSIONS_LOCATION = 41

    private lateinit var adapter: BluetoothMyAdapter
    private val devices: MutableList<MTBluetoothDevice> = ArrayList<MTBluetoothDevice>()
    private var btService: BLEService? = null
    private var deviceController: GLMDeviceController? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        BluetoothComponent.create(context)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BluetoothMyAdapter(this)
        adapter.onItemClick = { device ->


            if (btService!!.connectionState === MtAsyncConnection.STATE_CONNECTING) {

            } else {

                try {

                    if (btService!!.connectionState === MtAsyncConnection.STATE_CONNECTED
                        && btService!!.currentDevice.device.address != null
                        && device.device.address.equals(btService!!.currentDevice.device.address)
                    ) {
                        btService!!.disconnect()
                        refreshDeviceList()
                        viewModel.device.postValue(null)

                        returnTransition
                    }

                    btService!!.connect(device)
                    viewModel.device.postValue(device)


                } catch (e: BluetoothNotSupportedException) {
                    Log.e("MainActivity.TAG", "BluetoothNotSupportedException", e)
                }
            }
        }

        viewModel.deviceList.observe(viewLifecycleOwner) {
            it?.let {
                adapter.submitList(it)
            }
        }

        binding = BluetoothFragmentBinding.bind(view).apply {
            progressBle.visibility = View.GONE
            recyclerView.adapter = adapter

            LayoutHeaderViewHolder(layoutHeader, requireContext()).apply {
                layout_header_image.setImageResource(R.drawable.ic_baseline_refresh_24)
                layout_header_image.setPadding(15, 15, 15, 15)

                onItemClickImage = {
                    refreshDeviceList()
                    startDiscovery()
                    progressBle.visibility = View.VISIBLE
                }


                onItemClickButtonBack = {
                    findNavController().navigateUp()
                }
            }.bind(R.string.bluetooth_settings)


            viewModel.device.observe(viewLifecycleOwner) {
                adapter.submitList(mutableListOf(it))
            }

            btnTest.setOnClickListener {
                if (btService !== null && deviceController !== null) {

                    deviceController!!.qwe()
                }
            }
        }

        val serviceIntent = Intent(requireContext(), BLEService::class.java)
        requireContext().startService(serviceIntent)
        val mIntent = Intent(requireContext(), BLEService::class.java)

        requireContext().bindService(mIntent, mConnection, Context.BIND_AUTO_CREATE)
    }

    /**
     * Binds the Bluetooth service to the activity
     */
    private val mConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName) {
            Log.e("onServiceDisconnected", "Device activity on pause: cancel discovery")
            btService = null
        }

        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            Log.e("mConnection", "onServiceConnected")
            val mLocalBinder: BLEService.BLELocalBinder = service as BLEService.BLELocalBinder
            btService = mLocalBinder.service
        }
    }

    /**
     * Initializes the GLMDeviceController class, that will handle messages from and to GLM device
     */
    private fun setupDeviceController() {
        if (btService!!.isConnected) {
            if (deviceController == null) {
                deviceController = GLMDeviceController(btService)
                deviceController!!.init(btService!!.connection, btService!!.currentDevice)
                deviceController!!.turnLaserOn()

                val intent = Intent(Util.ACTION_SYNC_CONNECTION_RECEIVED)
                intent.putExtra(Util.ACTION_SYNC_CONNECTION_RECEIVED_STATE, true)
                requireContext().sendBroadcast(intent)

            } else {
                Timber.e(" setupDeviceController 123")
                destroyDeviceController()
                setupDeviceController()
            }
        } else {
            Timber.e(" setupDeviceController asd")
            destroyDeviceController()
        }
    }

    /**
     * Destroys the GLMDeviceController, when it is not needed anymore
     */
    private fun destroyDeviceController() {
        if (deviceController != null) {
            deviceController!!.destroy()
            deviceController = null
        }
    }

    override fun onPause() {
        super.onPause()
        requireContext().unregisterReceiver(mReceiver)

        // stop Bluetooth scan
        Timber.e(" onPause")
        btService?.cancelDiscovery()
    }


    /* (non-Javadoc)
     * @see android.app.Activity#onResume()
     */
    override fun onResume() {
        super.onResume()
        setTitle(R.string.app_name)
        refreshDeviceList()

        Timber.e(" onResume")
        // register receivers
        var filter: IntentFilter? = IntentFilter(BLEService.ACTION_DEVICE_LIST_UPDATED)
        requireContext().registerReceiver(mReceiver, filter)
        filter = IntentFilter(BLEService.ACTION_CONNECTION_STATUS_UPDATE)
        requireContext().registerReceiver(mReceiver, filter)
        filter = IntentFilter(GLMDeviceController.ACTION_SYNC_CONTAINER_RECEIVED)
        requireContext().registerReceiver(mReceiver, filter)

        // check if location permission available and request, if not
        if (Build.VERSION.SDK_INT >= 23) {
            val hasLocationPermission: Int =
                checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )

            val hasLocationPermission2: Int =
                checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                )

            if (hasLocationPermission != PackageManager.PERMISSION_GRANTED
                || hasLocationPermission2 != PackageManager.PERMISSION_GRANTED
            ) {
                requestLocationPermission()
                return
            }
        }


        // check if Bluetooth on and start it, if necessary
        if (btService != null && btService!!.enableBluetooth(requireActivity())) {
            startDiscovery()
        } else {
            binding?.progressBle?.visibility = View.GONE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == BLEService.REQUEST_ENABLE_BT) {
            if (resultCode == Activity.RESULT_OK) {
                startDiscovery()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.bluetooth_on_denied),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE_ASK_PERMISSIONS_LOCATION -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                if (btService != null && btService!!.enableBluetooth(requireActivity())) {

                    startDiscovery()
                }
            } else {
                // Permission Denied
                Toast.makeText(
                    requireContext(),
                    getString(R.string.location_permission_denied),
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {}
                //super.onRequestPermissionsResult(requestCode, permissions!!, grantResults)
        }
    }

    @TargetApi(23)
    private fun requestLocationPermission() {
        if (!shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION) ||
            !shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)
        ) {
            showPermissionMessageOKCancel(
                getString(R.string.request_location_permission)
            ) { dialog, which ->
                requestPermissions(
                    arrayOf(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ),
                    REQUEST_CODE_ASK_PERMISSIONS_LOCATION
                )
            }
            return
        }
        requestPermissions(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            REQUEST_CODE_ASK_PERMISSIONS_LOCATION
        )
    }


    private fun showPermissionMessageOKCancel(
        message: String,
        okListener: DialogInterface.OnClickListener
    ) {
        AlertDialog.Builder(requireContext())
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok), okListener)
            .setNegativeButton(getString(R.string.cancel), null)
            .create()
            .show()
    }

    /**
     * The BroadcastReceiver that handles notifications for discovered devices and new measurements
     */
    private val mReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        @SuppressLint("SetTextI18n")
        override fun onReceive(context: Context, intent: Intent) {
            if (intent != null && BLEService.ACTION_CONNECTION_STATUS_UPDATE.equals(intent.action)) {

                // Device was connected or disconnected - handle device list accordingly
                refreshDeviceList()
                if (adapter != null) {
                    //adapter.notifyDataSetChanged()
                }
                // If device was connected -> start GLMDeviceController to handle communication
                val connectionStatus = intent.getIntExtra(
                    BLEService.EXTRA_CONNECTION_STATUS,
                    MtAsyncConnection.STATE_NONE
                )
                if (connectionStatus == MtAsyncConnection.STATE_CONNECTED) {
                    setupDeviceController()
                    val deviceName = intent.getStringExtra(BLEService.EXTRA_DEVICE)

                    //devTextView.setText(resources.getString(R.string.connected_to) + deviceName)
                } else {
                    destroyDeviceController()
                    //devTextView.setText(resources.getString(R.string.no_device_connected))
                }
            } else if (intent != null && BLEService.ACTION_DEVICE_LIST_UPDATED.equals(intent.action)) {

                // Device list updated
                refreshDeviceList()
            } else if (intent != null && GLMDeviceController.ACTION_SYNC_CONTAINER_RECEIVED.equals(
                    intent.action
                )
            ) {

                // Measurement received
                if (!Objects.requireNonNull(intent.extras)?.isEmpty!!) {
                    val measurement =
                        intent.getFloatExtra(GLMDeviceController.EXTRA_MEASUREMENT, 0f)

                    Toast.makeText(requireContext(), "${measurement}", Toast.LENGTH_SHORT)
                        .show()

                }
            } else {

            }
        }
    }

    /**
     * Used to refresh the device list shown. If Bluetooth scanning is not enabled, the list will be empty
     */
    @Synchronized
    private fun refreshDeviceList() {
        binding?.progressBle?.visibility = View.GONE
        devices.clear()
        if (btService != null) {
            devices.addAll(btService!!.visibleDevices)
        }
        adapter.submitList(devices)
        viewModel.deviceList.postValue(devices)
        adapter.notifyDataSetChanged()
    }

    /**
     * Triggers discovery of Bluetooth devices for 5 seconds
     */
    private fun startDiscovery() {
        if (btService != null) {
            try {
                btService!!.startDiscovery()
            } catch (be: BluetoothNotSupportedException) {
                Log.e("vvvvvvvvvvvvvv", "Bluetooth not supported")
                be.printStackTrace()
            }
        }
    }

    /**
     * Get the binded BLEService
     * @return binded BLEService
     */
    fun getBluetoothService(): BLEService? {
        return btService
    }
}