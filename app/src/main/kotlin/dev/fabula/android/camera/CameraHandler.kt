package dev.fabula.android.camera

import android.annotation.SuppressLint
import android.content.Intent
import android.provider.MediaStore
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import dev.fabula.android.R
import timber.log.Timber

class CameraHandler {

    companion object {

        @SuppressLint("ResourceType")
        fun getPhotoFromGallery(activity: AppCompatActivity) {

            AlertDialog.Builder(activity)
                .setTitle(activity.resources.getString(R.string.select_image))
                .setPositiveButton(activity.resources.getString(R.string.camera)) { p0, p1 ->
                    try {
                        Timber.e("getPhotoFromGallery onCameraClick start")
                        val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                        activity.startActivityForResult(takePicture, 101)
                        Timber.e("getPhotoFromGallery onCameraClick end")
                    } catch (e: Exception) {
                        Timber.e("getPhotoFromGallery onCameraClick ${e.message}")
                    } finally {
                        p0?.dismiss()
                    }
                }
                .setNegativeButton(activity.resources.getString(R.string.gallery)) { p0, p1 ->
                    try {

                        val pickPhoto = Intent(
                            Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        )
                        activity.startActivityForResult(
                            pickPhoto,
                            111
                        )
                    } catch (e: Exception) {
                        Timber.e("getPhotoFromGallery onGalleryClick ${e.message}")
                    } finally {
                        p0?.dismiss()
                    }
                }
                .show()
        }
    }
}