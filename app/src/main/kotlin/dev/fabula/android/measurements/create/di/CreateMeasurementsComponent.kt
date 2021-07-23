package dev.fabula.android.measurements.create.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.canopy.di.CanopyDaoModule
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao
import dev.fabula.android.dimensions.fence.di.DimensionsFenceDaoModule
import dev.fabula.android.measurements.create.ui.CreateMeasurementsFragment

@Component(
    modules = [
        CreateMeasurementsModule::class,
        CreateMeasurementsApiModule::class,
        CreateMeasurementsDaoModule::class,
        CanopyDaoModule::class,
        DimensionsFenceDaoModule::class
    ],
    dependencies = [AppComponent::class]
)
interface CreateMeasurementsComponent {

    companion object {
        fun create(context: Context): CreateMeasurementsComponent {
            return DaggerCreateMeasurementsComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent)
                .build()
        }
    }

    fun inject(fragment: CreateMeasurementsFragment)
}