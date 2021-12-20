package dev.fabula.android.measurements.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.fabula.android.R
import dev.fabula.android.app.ui.Event
import dev.fabula.android.bluetooth.GLMDeviceController
import dev.fabula.android.measurements.create.ui.CreateMeasurementsFragment
import dev.fabula.android.measurements.model.BoschMeasurement
import dev.fabula.android.measurements.model.LittleMeasurement
import dev.fabula.android.measurements.model.MeasureCalc
import dev.fabula.android.measurements.model.MeasureCalibration
import kotlin.math.abs
import kotlin.math.sin

class MeasurementReceiver(context: Context, receiverTag: String) {
    private var ctx = context
    private var RECEIVER_TAG = receiverTag
    private lateinit var receiver: BroadcastReceiver

    private val _boschMeasurement = MutableLiveData<Event<BoschMeasurement>>()
    val boschMeasurement: LiveData<Event<BoschMeasurement>>
        get() = _boschMeasurement

    fun initializeReceiver() {
        val filter = IntentFilter(RECEIVER_TAG)

        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent) {

                var prevResult = Float.MIN_VALUE.toDouble()
                val result =
                    intent.extras!!.getFloat(GLMDeviceController.EXTRA_MEASUREMENT).toDouble()
                val devMode =
                    intent.extras!!.getInt(GLMDeviceController.EXTRA_MEASUREMENT_TYPE).toDouble()
                val gipotinuza =
                    intent.extras!!.getFloat(GLMDeviceController.EXTRA_MEASUREMENT_COMP1).toDouble()
                val ugol =
                    intent.extras!!.getFloat(GLMDeviceController.EXTRA_MEASUREMENT_COMP2).toDouble()

                Log.e("BroadcastReceiver2", "$result / $gipotinuza / $ugol / $devMode")

                if (prevResult != gipotinuza) {
                    prevResult = gipotinuza
                } else {
                    return
                }

                _boschMeasurement.postValue(
                    Event(
                        BoschMeasurement(
                            result,
                            devMode,
                            gipotinuza,
                            ugol
                        )
                    )
                )
            }
        }
        ctx.registerReceiver(receiver, filter)
    }

    fun calculateMeasure(boschMeasure: BoschMeasurement): MeasureCalibration {

        boschMeasure.gipotinuza *= 1000.0
        val L1 = boschMeasure.gipotinuza
        val a1 = boschMeasure.ugol
        val L0 = ((L1 + 760) / 2)
        val dh = abs(2 * L0 * sin(Math.toRadians(a1)))

        return MeasureCalibration(L1, a1, L0, dh)
    }

    fun calculateMeasure(
        L0: Double,
        L1: Double,
        L2: Double,
        a1: Double,
        a2: Double,
        context: Context,
        dh:Double
    ): LittleMeasurement {

        val dx = L0 - L1
        val dL = dx * Math.cos(Math.toRadians(a1))
        val dh3 =
            (L0 - dx) * sin(Math.toRadians(a1))
        val Ldk = Math.cos(Math.toRadians(a2)) * L2
        val Hdk = sin(Math.toRadians(a2)) * L2
        val L = Ldk + dL
        val Hvn = Hdk - dh3

        val Hmin = if (a1 <= 0) {
            Hvn - (abs(L0 * sin(Math.toRadians(a1))) * sin(
                Math.toRadians(a2)
            ))
        } else {
            Hvn
        }

        val info = String.format(
            "[L0: %f]  - ${context.resources.getString(R.string.track_axis)}" +
                    "\n[dh: %f] - ${context.resources.getString(R.string.rail_elevation)}" +
                    "\n[dx: %f] - ${context.resources.getString(R.string.axis_offset)}" +
                    "\n[dL: %f] - ${context.resources.getString(R.string.length_correction)}" +
                    "\n[dh3: %f] - ${context.resources.getString(R.string.height_correction)}" +
                    "\n[Ldk: %f] - ${context.resources.getString(R.string.indirect_length)}" +
                    "\n[Hdk: %f] - ${context.resources.getString(R.string.indirect_height)}" +
                    "\n[L: %f] - ${context.resources.getString(R.string.length_from_track_axis)}" +
                    "\n[Hvn: %f] - ${context.resources.getString(R.string.height_from_the_head_of_the_inner_rail)}" +
                    "\n[a1: %f] - ${context.resources.getString(R.string.rail_inclination)}" +
                    "\n[a2: %f] - ${context.resources.getString(R.string.angle_from_horizon_to_point)}" +
                    "\n[Hmin: %f] - ${context.resources.getString(R.string.for_overhead_cables_and_horizontal_objects)}" +
                    "\n\n",
            L0, dh, dx, dL, dh3, Ldk, Hdk, L, Hvn, a1, a2, Hmin
        )

        return LittleMeasurement(L, Hvn, Hmin, info)
    }

    fun destroyReceiver() {
        ctx.unregisterReceiver(receiver)
    }
}