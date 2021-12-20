package dev.fabula.android.platform.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.canopy.di.CanopyDaoModule
import dev.fabula.android.dimensions.fence.di.DimensionsFenceDaoModule
import dev.fabula.android.dimensions.fence.di.DimensionsFenceModule
import dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule
import dev.fabula.android.measurements.type.di.MeasurementTypeDaoModule
import dev.fabula.android.platform.ui.PlatformFragment
import dev.fabula.android.support.di.SupportDaoModule

@Component(
    modules = [
        PlatformModule::class,
        PlatformDaoModule::class,
        CanopyDaoModule::class,
        SupportDaoModule::class,
        DimensionsFenceModule::class,
        PlatformDaoModule::class,
        DimensionsFenceDaoModule::class,
        CreateMeasurementsDaoModule::class,
        MeasurementTypeDaoModule::class
    ],
    dependencies = [AppComponent::class]
)
interface PlatformComponent {

    companion object {
        fun create(context: Context): PlatformComponent {
            return DaggerPlatformComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent)
                .build()
        }
    }

    fun inject(fragment: PlatformFragment)
}