package dev.fabula.android.bosch.otg.file

import android.content.Context
import android.graphics.BitmapFactory
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import dev.fabula.android.bosch.otg.data.source.BoschOtgDataSource
import dev.fabula.android.bosch.otg.model.BoschOtgItemList
import java.io.File

class BoschFileOtg : BoschOtgDataSource {

    private val DIR_PATH: String = "/storage/usbotg/IMAGE/"

    private fun readAllWithHeaderAsSequence(
        file: File,
        context: Context
    ): ArrayList<BoschOtgItemList> {
        val listData: ArrayList<BoschOtgItemList> = ArrayList()
        val photoFile = File(DIR_PATH)
        val listPhotos = photoFile.listFiles()

        csvReader().open(file) {
            readAllWithHeaderAsSequence().forEachIndexed { index, map ->

                val bitmap = BitmapFactory.decodeFile(listPhotos[index].toString())

                map["Date"]?.let {
                    map["Function"]?.let { it1 ->
                        map["Measurement"]?.let { it2 ->
                            map["Value1"]?.let { it3 ->
                                map["Value3"]?.let { it4 ->
                                    BoschOtgItemList(
                                        it,
                                        it1,
                                        map["Operation"],
                                        map["Reference"],
                                        it2,
                                        map["Unit"],
                                        it3,
                                        map["Unit1"],
                                        map["Value2"],
                                        map["Unit2"],
                                        it4,
                                        map["Unit3"],
                                        map["Image No."],
                                        bitmap
                                    )
                                }
                            }
                        }
                    }
                }?.let {
                    listData.add(
                        it
                    )
                }
            }
        }
        return listData
    }

    override suspend fun getMeasurementsFromBoschDevice(
        file: File,
        context: Context
    ): List<BoschOtgItemList> {
        return try {
            return readAllWithHeaderAsSequence(file, context)
        } catch (e: Exception) {
            listOf()
        }
    }
}