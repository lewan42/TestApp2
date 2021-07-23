package dev.fabula.android.dimensions.fence.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.dimensions.fence.ui.DimensionsFenceFragment
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao
import dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao
import dev.fabula.android.measurements.type.di.MeasurementTypeDaoModule
import dev.fabula.android.platform.di.PlatformDaoModule

@Component(
    modules = [
        DimensionsFenceModule::class,
        PlatformDaoModule::class,
        DimensionsFenceDaoModule::class,
        CreateMeasurementsDaoModule::class,
        MeasurementTypeDaoModule::class
    ],
    dependencies = [AppComponent::class]
)
interface DimensionsFenceComponent {
    companion object {
        fun create(context: Context): DimensionsFenceComponent {
            return DaggerDimensionsFenceComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent).build()
        }
    }

    fun inject(fragment: DimensionsFenceFragment)
}