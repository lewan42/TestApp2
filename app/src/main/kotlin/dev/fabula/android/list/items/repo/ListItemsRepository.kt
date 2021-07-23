package dev.fabula.android.list.items.repo

import android.util.Log
import androidx.annotation.WorkerThread
import dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao
import dev.fabula.android.bridge.crossing.model.BridgeCrossing
import dev.fabula.android.canopy.dao.CanopyDao
import dev.fabula.android.canopy.model.Canopy
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.list.items.model.ListItem
import dev.fabula.android.platform.dao.PlatformDao
import dev.fabula.android.platform.model.Platform
import dev.fabula.android.support.dao.SupportDao
import dev.fabula.android.support.model.Support
import java.util.*
import javax.inject.Inject

class ListItemsRepository @Inject constructor(
    private val platformDao: PlatformDao,
    private val bridgeCrossingDao: BridgeCrossingDao,
    private val supportDao: SupportDao,
    private val dimensionsFenceDao: DimensionsFenceDao,
    private val canopyDao: CanopyDao

) {
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getPlatformsOfStationOrPeregon(uidStationOrPeregon: String): List<ListItem> {
        return convertListOfPlatform(platformDao.getPlatformsOfStationOrPeregon(uidStationOrPeregon))
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getBridgesCrossingOfRailwaySection(uidStationOrPeregon: String): List<ListItem> {
        return convertListOfBridgesCrossing(bridgeCrossingDao.getBridgesCrossing(uidStationOrPeregon))
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getSupports(uidStationOrPeregon: String): List<ListItem> {
        return convertListOfSupports(supportDao.getSupportsOfParent(uidStationOrPeregon))
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getDimensionFenceOfPlatform(uidPlatform: String): List<ListItem> {
        Log.e("ZZZZZZZZ:", "${uidPlatform}")
        return convertListOfDimensions(dimensionsFenceDao.getDimensionsFenceOfPlatform(uidPlatform))
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getBridgesOfPlatform(uidPlatform: String): List<ListItem> {
        return convertListOfBridgesCrossing(bridgeCrossingDao.getBridgesCrossing(uidPlatform))
        //return emptyList()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getCanopiesOfPlatform(uidPlatform: String): List<ListItem> {
        return convertListOfCanopies(canopyDao.getCanopiesOfParent(uidPlatform))
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getSupportsOfPlatform(uidPlatform: String): List<ListItem> {
        return convertListOfSupports(supportDao.getSupportsOfParent(uidPlatform))
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getSupportsOfBridge(uidBridge: String): List<ListItem> {
        return convertListOfSupports(supportDao.getSupportsOfParent(uidBridge))
    }

    private fun convertListOfPlatform(list: List<Platform>): List<ListItem> {
        val result = mutableListOf<ListItem>()
        list.forEach {
            result.add(ListItem(it.uid, it.number))
        }
        return result
    }


    private fun convertListOfBridgesCrossing(list: List<BridgeCrossing>): List<ListItem> {
        Log.e("listOfBridgesCrossing:", "${list.size}")
        val result = mutableListOf<ListItem>()
        list.forEach {
            result.add(ListItem(it.uid, it.name))
        }
        return result
    }

    private fun convertListOfSupports(list: List<Support>): List<ListItem> {
        val result = mutableListOf<ListItem>()
        Log.e("convertListOfSupports:", "${list.size}")
        list.forEach {
            result.add(ListItem(it.uid, it.number))
        }
        return result
    }

    private fun convertListOfDimensions(list: List<DimensionsFence>): List<ListItem> {
        val result = mutableListOf<ListItem>()
        Log.e("convertListOfDimensions", "${list.size}")
        list.forEach {
            result.add(ListItem(it.uid, it.direction))
        }
        return result
    }

    private fun convertListOfCanopies(list: List<Canopy>): List<ListItem> {
        val result = mutableListOf<ListItem>()
        Log.e("convertListOfCanopies", "${list.size}")
        list.forEach {
            result.add(ListItem(it.uid, it.platform_uid))
        }
        return result
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createCanopy(uidPlatform: String): String? {
        try {
            val uidCanopy = UUID.randomUUID().toString()
            canopyDao.insert(Canopy(uidCanopy, uidPlatform, null, null, null, true, false))
            return uidCanopy
        } catch (e: Exception) {
            return null
        }
    }

    /*
    contentType - к чему привязана опора (к "платформе") название
     */
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createSupport(uidPlatform: String, contentType: String): String? {
        try {
            val uidSupport = UUID.randomUUID().toString()
            supportDao.insert(
                Support(
                    uidSupport,
                    contentType,
                    uidPlatform,
                    "Название",
                    "Км пути",
                    "Номер пути",
                    "Пикет",
                    "",
                    "",
                    "",
                    "",
                    "",
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
    suspend fun create(uidPlatform: String): String? {
        try {
            val uidCanopy = UUID.randomUUID().toString()
            canopyDao.insert(Canopy(uidCanopy, uidPlatform, null, null, null, true, false))
            return uidCanopy
        } catch (e: Exception) {
            return null
        }
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createBridge(uidPlatform: String, owner: String?): String? {
        try {
            val uidBridge = UUID.randomUUID().toString()
            bridgeCrossingDao.insert(
                BridgeCrossing(
                    uidBridge,
                    "Мостовой переход",
                    uidPlatform,
                    owner,
                    true,
                    false
                )
            )
            return uidBridge
        } catch (e: Exception) {
            return null
        }
    }

//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    suspend fun createSupport(uidParent: String): String? {
//        try {
//            val uidBridge = UUID.randomUUID().toString()
//            supportDao.insert(
//                Support(
//                    uidBridge,
//                    uidPlatform,
//                    "Мостовой переход",
//                    owner
//                )
//            )
//            return uidBridge
//        } catch (e: Exception) {
//            return null
//        }
//    }
}