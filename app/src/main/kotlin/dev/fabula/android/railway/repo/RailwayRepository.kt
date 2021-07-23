package dev.fabula.android.railway.repo

import dev.fabula.android.railway.dao.RailwayDao
import dev.fabula.android.railway.model.Railway
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RailwayRepository @Inject constructor(railwayDao: RailwayDao) {

    val allRailways: Flow<List<Railway>> = railwayDao.getRailways()
}