package dev.fabula.android.bridge.crossing.repo

import androidx.annotation.WorkerThread
import dev.fabula.android.auth_old.AppAuth
import dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao
import dev.fabula.android.bridge.crossing.model.BridgeCrossing
import dev.fabula.android.platform.dao.PlatformDao
import dev.fabula.android.support.dao.SupportDao
import dev.fabula.android.support.model.Support
import timber.log.Timber
import java.lang.Exception
import java.util.*
import javax.inject.Inject

class BridgeRepository @Inject constructor(
    private val platformDao: PlatformDao,
    private val supportDao: SupportDao,
    private val bridgeCrossingDao: BridgeCrossingDao,
    private val auth: AppAuth
) {
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getPlatformName(uidPlatform: String): String {
        return platformDao.getPlatformName(uidPlatform)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createBridge(uidPlatform: String): String? {
        val uidBridge = UUID.randomUUID().toString()
        try {
            bridgeCrossingDao.insert(
                BridgeCrossing(
                    uidBridge,
                    "Мостовой переход",
                    uidPlatform,
                    auth.getUserID(),
                    true,
                    false
                )
            )
            return uidBridge
        } catch (e: Exception) {
            Timber.e("BridgeRepository createBridge: ${e.message}")
        }
        return null
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getBridgeNameById(uid: String): String {
        return bridgeCrossingDao.getBridgeName(uid)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getSupportsOfBridge(uidBridge: String): List<Support> {
        return supportDao.getSupportsOfParent(uidBridge)
    }
}
