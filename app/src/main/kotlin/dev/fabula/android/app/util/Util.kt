package dev.fabula.android.app.util

import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.MutableLiveData
import dev.fabula.android.bluetooth.bluetooth.MTBluetoothDevice

public class Util {
    public companion object {

        const val ACTION_SYNC_CONNECTION_RECEIVED = "ACTION_SYNC_CONNECTION_RECEIVED"
        const val ACTION_SYNC_CONNECTION_RECEIVED_STATE = "ACTION_SYNC_CONNECTION_RECEIVED_STATE"

        const val station: String = "Station"
        //const val platform: String = "Платформа"
        //const val canopy: String = "Навес"
        const val support: String = "опора"
        const val peregon: String = "Peregon"

        var NFC_TAG = MutableLiveData<Tag?>()
        var NFC_TAG_NEXT = true
        var BOSCH_DEVICE: String = ""

        var STATE_BLUETOOTH_CONNECTION = false

        var CERTIFICATE_1 = "Госреестр № 44551- 10, заводской № 806325544, инв. № 580000026941."
        var CERTIFICATE_2 = "Свидетельство о проверке No 380342, действительно до 24 февраля 2021 года."
        var CERTIFICATE_3 = "УШГ 00.000. зав. № 580000009030."
        var CERTIFICATE_4 = "Сертификат № Е/3368, действителен до 04 июня 2020 года."
        var CERTIFICATE_5 = "Лазерный дальномер Bosch GLM 250 VF Professional №80627 LC ."


        const val canopy_type_north = 0
        const val canopy_type_center = 1
        const val canopy_type_south = 2

        const val height_contact_wire = "высота контактного провода"
        const val zigzag_contact_wire = "зигзаг контактного провода"
        const val height_carrier_wire = "высота несущего провода"
        const val zigzag_carrier_wire = "зигзаг несущего провода"

        const val platform_type_measurement = "платформа"
        const val dimensions_fence_type = "габарит торцевого ограждения"
        const val dimensions_canopy_type = "габарит навеса"
        const val bridge_down = "спуск мостового перехода"


        var HEIGHT_NORM = 0
        var WIDTH_NORM = 0


        fun cutMeasurement(str: String?): String {
            if (str == null) return ""
            return try {
                val arr = str.split(".")
                StringBuffer(arr[0]).append(".").append(arr[1][0]).append(arr[1][1]).toString()
            } catch (e: Exception) {
                Log.e("Util", "cutMeasurement")
                ""
            }
        }
    }
}