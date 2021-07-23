package dev.fabula.android.support.repo

import android.util.Log
import androidx.annotation.WorkerThread
import dev.fabula.android.app.util.Util
import dev.fabula.android.auth.remote.AuthRequest
import dev.fabula.android.auth.remote.AuthResponse
import dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao
import dev.fabula.android.measurements.model.Measurement
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao
import dev.fabula.android.measurements.type.model.MeasurementType
import dev.fabula.android.platform.dao.PlatformDao
import dev.fabula.android.support.api.SupportApi
import dev.fabula.android.support.dao.SupportDao
import dev.fabula.android.support.model.Support
import dev.fabula.android.support.model.SupportResponse
import dev.fabula.android.wire.carrier.dao.CarrierWireDao
import dev.fabula.android.wire.carrier.model.CarrierWire
import dev.fabula.android.wire.contact.dao.ContactWireDao
import dev.fabula.android.wire.contact.model.ContactWire
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class SupportRepository @Inject constructor(
    private val supportDao: SupportDao,
    private val supportApi: SupportApi,
    private val platformDao: PlatformDao,
    private val bridgeDao: BridgeCrossingDao,
    private val contactWireDao: ContactWireDao,
    private val carrierWireDao: CarrierWireDao,
    private val measurementTypeDao: MeasurementTypeDao,
    private val createMeasurementsDao: CreateMeasurementsDao
) {

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun supportUpdate(
        uidSupport: String,
        number: String,
        kmWay: String,
        wayNumber: String,
        picket: String,
        comment: String?,
        photo1: String?,
        photo2: String?
    ): Boolean {
        return try {
            supportDao.update(uidSupport, number, kmWay, wayNumber, picket, comment, photo1, photo2)
            true
        } catch (e: Exception) {
            false
        }
    }


    /*
    contentType - к чему привязана опора (к "платформе") название
     */
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createSupport(
        uidPlatform: String,
        contentType: String,
        number: String,
        kmWay: String,
        wayNumber: String,
        picket: String,
        photo1: String?,
        photo2: String?
    ): String? {

        try {
            val uidSupport = UUID.randomUUID().toString()
            supportDao.insert(
                Support(
                    uidSupport,
                    contentType,
                    uidPlatform,
                    number,
                    kmWay,
                    wayNumber,
                    picket,
                    null,
                    null,
                    null,
                    photo1,
                    photo2,
                    true,
                    false
                )
            )
            return uidSupport
        } catch (e: Exception) {
            return null
        }
    }


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun countWiresOfSupport(uidSupport: String): Boolean {
        return try {
            val countContactWire = getCountContactWireOfSupport(uidSupport)
            val countCarrierWire = getCountContactWireOfSupport(uidSupport)
            if (countContactWire != 2 || countCarrierWire != 2) {
                return false
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getCarrierWireBySupport(uidSupport: String): CarrierWire {
        return carrierWireDao.getCarrierWireOfSupport(uidSupport)
    }

    fun getContactWireForBySupport(uidSupport: String): ContactWire? {
        try {
            val uidContactWire = UUID.randomUUID().toString()

            val count = contactWireDao.getCountContactWireOfSupport(uidSupport)
            if (count == 0) {

                val heightContactWire =
                    measurementTypeDao.getTypeMeasurementByType(Util.height_contact_wire)

                val zigzagContactWire =
                    measurementTypeDao.getTypeMeasurementByType(Util.zigzag_contact_wire)

                val contactWire = ContactWire(
                    uidContactWire,
                    uidSupport,
                    heightContactWire.uid,
                    zigzagContactWire.uid,
                    true
                )

                contactWireDao.insert(contactWire)
                return contactWire
            } else {
                return contactWireDao.getContactWireOfSupport(uidSupport)
            }

        } catch (e: Exception) {
            Timber.e("createContactWireOfSupport : ${e.message}")
            return null
        }
    }

    fun getCarrierWireForBySupport(uidSupport: String): CarrierWire? {
        try {
            val uidCarrierWire = UUID.randomUUID().toString()

            val count = carrierWireDao.getCountCarrierWireOfSupport(uidSupport)
            if (count == 0) {

                val heightCarrierWire =
                    measurementTypeDao.getTypeMeasurementByType(Util.height_carrier_wire)

                val zigzagCarrierWire =
                    measurementTypeDao.getTypeMeasurementByType(Util.zigzag_carrier_wire)

                val carrierWire = CarrierWire(
                    uidCarrierWire,
                    uidSupport,
                    heightCarrierWire.uid,
                    zigzagCarrierWire.uid,
                    true
                )

                carrierWireDao.insert(carrierWire)
                Timber.e("getCarrierWireForBySupport created : $carrierWire")
                return carrierWire
            } else {
                val carrierWire = carrierWireDao.getCarrierWireOfSupport(uidSupport)
                Timber.e("getCarrierWireForBySupport existed : $carrierWire")
                return carrierWire
            }

        } catch (e: Exception) {
            Timber.e("getCarrierWireForBySupport : ${e.message}")
            return null
        }
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getMeasurementByParentContactWire(
        uidContactWire: String, uidTypeMeasurement: String
    ): Measurement? {
        return createMeasurementsDao.getMeasurementsOfContactWire(
            uidContactWire,
            uidTypeMeasurement
        )
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getMeasurementByParentCarrierWire(
        uidCarrierWire: String, uidTypeMeasurement: String
    ): Measurement? {
        return createMeasurementsDao.getMeasurementsOfCarrierWire(
            uidCarrierWire,
            uidTypeMeasurement
        )
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getSupportById(uidSupport: String): Support {
        return supportDao.getSupportById(uidSupport)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getCountContactWireOfSupport(uidSupport: String): Int {
        return contactWireDao.getCountContactWireOfSupport(uidSupport)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getPlatformName(uidPlatform: String): String {
        return platformDao.getPlatformName(uidPlatform)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getBridgeName(uidBridge: String): String {
        return bridgeDao.getBridgeName(uidBridge)
    }
}