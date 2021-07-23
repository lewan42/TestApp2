package dev.fabula.android.app.ui

import android.Manifest
import android.app.AlertDialog
import android.app.PendingIntent
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Bitmap
import android.nfc.NfcAdapter
import android.nfc.NfcManager
import android.nfc.Tag
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.util.Util
import dev.fabula.android.camera.CameraHandler
import dev.fabula.android.camera.CameraViewModel
import timber.log.Timber
import java.io.IOException
import kotlin.math.sin

class AppActivity : AppCompatActivity() {

    private val CAMERA_REQUEST_CODE = 100

    private val cameraViewModel: CameraViewModel by viewModels()
    private var mIMAGE = 0

    private var adapter: NfcAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as BaseApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        Timber.d("onCreate $intent")
        initNfcAdapter()
        listenActionPhoto()
    }

    private fun listenActionPhoto() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.CAMERA
                )
            ) {
                alertDialog()
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    CAMERA_REQUEST_CODE
                )
            }
        }

        cameraViewModel.actionPhoto.event(this) {
            mIMAGE = 0
            CameraHandler.getPhotoFromGallery(this)
        }
        cameraViewModel.actionPhoto2.event(this) {
            mIMAGE = 1
            CameraHandler.getPhotoFromGallery(this)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, imageReturnedIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent)
        Timber.e("onActivityResult 1")
        when (requestCode) {

            101 -> if (resultCode == RESULT_OK) {
                imageReturnedIntent?.extras?.get("data").let {
                    when (mIMAGE) {
                        0 -> cameraViewModel.setPhotoActivityResult(it as Bitmap)
                        1 -> cameraViewModel.setPhotoActivityResult2(it as Bitmap)
                    }
                }
            }

            111 -> if (resultCode == RESULT_OK) {
                try {
                    MediaStore.Images.Media.getBitmap(
                        this.contentResolver,
                        imageReturnedIntent?.data
                    ).let {
                        when (mIMAGE) {
                            0 -> cameraViewModel.setPhotoActivityResult(it)
                            1 -> cameraViewModel.setPhotoActivityResult2(it)
                        }
                    }

                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(applicationContext, "Failed!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun alertDialog() {
        val menu = arrayOf<CharSequence>("Take From Galery", "Open Camera")
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Pick a Picture")
        builder.setItems(menu, DialogInterface.OnClickListener { dialogInterface, i ->
            if (i == 0) {
                Toast.makeText(applicationContext, "galery", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent("android.media.action.IMAGE_CAPTURE")
                startActivity(intent)
            }
        })
        builder.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.appNavHostFragment)
        return navController.navigateUp()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Timber.d("onConfigurationChanged $newConfig")
    }

    fun initNfcAdapter() {

        val nfcManager = getSystemService(Context.NFC_SERVICE) as NfcManager
        adapter = nfcManager.defaultAdapter
    }

    fun enableNfcForegroundDispatch() {
        try {
            val intent =
                Intent(this, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            val nfcPendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
            adapter?.enableForegroundDispatch(this, nfcPendingIntent, null, null)
        } catch (ex: IllegalStateException) {
            Log.e("getTag()", "Error enabling NFC foreground dispatch", ex)
        }
    }

    fun disableNfcForegroundDispatch() {
        try {
            adapter?.disableForegroundDispatch(this)
        } catch (ex: IllegalStateException) {
            Log.e("getTag()", "Error disabling NFC foreground dispatch", ex)
        }
    }

    override fun onResume() {
        super.onResume()
        enableNfcForegroundDispatch()
    }

    override fun onPause() {
        disableNfcForegroundDispatch()
        super.onPause()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Timber.d("onNewIntent $intent")
        Log.e("AAAA", "AAAAASSSSS")

        if (Util.NFC_TAG_NEXT) {
            Util.NFC_TAG.value = intent.getParcelableExtra<Tag>(NfcAdapter.EXTRA_TAG)
        }
    }

//    companion object {
//
//
//
//        private var adapter: NfcAdapter? = null
//        fun initNfcAdapter(activity: AppActivity) {
//
//            val nfcManager = activity.getSystemService(Context.NFC_SERVICE) as NfcManager
//            adapter = nfcManager.defaultAdapter
//        }
//
//        fun enableNfcForegroundDispatch(activity: AppActivity) {
//            try {
//                val intent =
//                    Intent(activity, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
//                val nfcPendingIntent = PendingIntent.getActivity(activity, 0, intent, 0)
//                adapter?.enableForegroundDispatch(activity, nfcPendingIntent, null, null)
//            } catch (ex: IllegalStateException) {
//                Log.e("getTag()", "Error enabling NFC foreground dispatch", ex)
//            }
//        }
//
//        fun disableNfcForegroundDispatch(activity: AppActivity) {
//            try {
//                adapter?.disableForegroundDispatch(activity)
//            } catch (ex: IllegalStateException) {
//                Log.e("getTag()", "Error disabling NFC foreground dispatch", ex)
//            }
//        }
//    }
}
