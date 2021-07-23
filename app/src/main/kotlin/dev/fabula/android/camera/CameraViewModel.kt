package dev.fabula.android.camera

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.provider.MediaStore
import android.util.Base64
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import dev.fabula.android.app.ui.BaseViewModel
import dev.fabula.android.app.ui.Event
import timber.log.Timber
import java.io.ByteArrayOutputStream

class CameraViewModel : BaseViewModel() {

    val actionPhoto = MutableLiveData<Event<Boolean>>()
    val actionPhoto2 = MutableLiveData<Event<Boolean>>()

    private val _takePhotoAction = MutableLiveData<Event<Bitmap>>()
    val takePhotoAction: LiveData<Event<Bitmap>>
        get() = _takePhotoAction

    private val _takePhotoAction2 = MutableLiveData<Event<Bitmap>>()
    val takePhotoAction2: LiveData<Event<Bitmap>>
        get() = _takePhotoAction2

    fun setPhotoActivityResult(bitmapPhoto: Bitmap) {
        Timber.e("setPhotoActivityResult ${bitmapPhoto}")
        _takePhotoAction.postValue(Event(bitmapPhoto))
    }

    fun setPhotoActivityResult2(bitmapPhoto: Bitmap) {
        Timber.e("setPhotoActivityResult2 ${bitmapPhoto}")
        _takePhotoAction2.postValue(Event(bitmapPhoto))
    }

    fun convertImage(encodedImage: String?): Bitmap? {
        return try {
            val encodedImage1 = encodedImage?.replace("data:image/png;base64,", "")
            val encodedImage2 = encodedImage1?.replace("data:image/jpg;base64,", "")
            val decodedString: ByteArray = Base64.decode(encodedImage2, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        } catch (e: Exception) {
            Timber.e("CameraViewModel convertImage ${e.message}")
            null
        }
    }

    fun insertBitmapOnImageView(context: Context, bitmap: Bitmap, imageView: AppCompatImageButton) {
        Timber.e("insertBitmapOnImageView")
        try{
            Glide.with(context)
                .asBitmap()
                .load(bitmap)
                .into(imageView)
        }catch (e: Exception){
            Timber.e("insertBitmapOnImageView: ${e.message}")
        }
    }

    fun convertImage(image: AppCompatImageButton): String? {
        return try {
            val resized = Bitmap.createScaledBitmap(
                (image.drawable as BitmapDrawable).bitmap,
                1024,
                768,
                true
            )

            val nh = (resized.height * (512.0 / resized.width)).toInt()
            val scaled = Bitmap.createScaledBitmap(resized, 512, nh, true)
            convertImage(scaled)
        } catch (e: Exception) {
            Timber.e("convertImage image: AppCompatImageButton: ${e.message}")
            null
        }
    }

    fun convertImage(bitmap: Bitmap?): String? {

        return try {
            if (bitmap == null) return null
            val nh = (bitmap.height * (512.0 / bitmap.width)).toInt()
            val lowerBitmap = Bitmap.createScaledBitmap(bitmap, 512, nh, true)
            val byteArrayOutputStream = ByteArrayOutputStream()
            lowerBitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream)
            val byteArray: ByteArray = byteArrayOutputStream.toByteArray()
            return "data:image/png;base64," + Base64.encodeToString(byteArray, Base64.DEFAULT)
        } catch (e: Exception) {
            Timber.e("convertImage bitmap: Bitmap: ${e.message}")
            null
        }
    }


    fun convertImage(res: Int, context: Context): String? {
        val bitmap: Bitmap = BitmapFactory.decodeResource(context.resources, res)
        return convertImage(bitmap)
    }

}