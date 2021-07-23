package dev.fabula.android.report.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.report.dao.ReportDao

@Module
class ReportDaoModule {
    @Provides
    fun providesReportDAO(appDatabase: AppRoomDatabase): ReportDao {
        return appDatabase.reportDao()
    }
}
