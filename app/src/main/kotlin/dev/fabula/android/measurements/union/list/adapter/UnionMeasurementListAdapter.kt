package dev.fabula.android.measurements.union.list.adapter

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.fabula.android.databinding.ItemUnionBinding
import dev.fabula.android.databinding.RailwayItemBinding
import dev.fabula.android.measurements.list.adapter.MeasurementsListDiffUtilCallback
import dev.fabula.android.measurements.model.Measurement
import timber.log.Timber

typealias onItemClick = ((Measurement) -> Unit)

class UnionMeasurementListAdapter :
    ListAdapter<Measurement, UnionMeasurementListAdapter.ViewHolder>(
        MeasurementsListDiffUtilCallback()
    ) {

    var onItemClick: onItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemUnionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }

    inner class ViewHolder(val binding: ItemUnionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Measurement, pos: Int) {

            binding.length.text = "Длина  ${item.vertical_gabarit}"
            binding.height.text = "Высота ${item.horizontal_gabarit}"
            binding.gipotinuza.text = "Гипотинуза ${item.gipotinuza}"
            binding.ugol.text = "Угол ${item.ugol_naklona}"
            binding.image.setImageBitmap(convertImage(item.photo1))
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
    }
}