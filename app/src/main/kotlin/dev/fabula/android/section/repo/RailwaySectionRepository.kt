package dev.fabula.android.section.repo

import androidx.annotation.WorkerThread
import dev.fabula.android.section.dao.RailwaySectionDao
import dev.fabula.android.section.model.RailwaySection
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RailwaySectionRepository @Inject constructor(
    private val railwaySectionDao: RailwaySectionDao
) {

    val allRailwaySections: Flow<List<RailwaySection>> = railwaySectionDao.getRailwaySections()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getRailwaySections(uid_railway: String): List<RailwaySection> {
        return railwaySectionDao.getRailwaySections(uid_railway)
    }
}