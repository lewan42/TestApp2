package dev.fabula.android.measurements.list.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.canopy.dao.CanopyDao
import dev.fabula.android.canopy.di.CanopyDaoModule
import dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule
import dev.fabula.android.measurements.list.ui.MeasurementsListFragment
import dev.fabula.android.measurements.type.di.MeasurementTypeDaoModule

@Component(
    modules = [
        MeasurementListModule::class,
        CreateMeasurementsDaoModule::class,
        CanopyDaoModule::class,
        MeasurementTypeDaoModule::class
    ], dependencies = [AppComponent::class]
)
interface MeasurementsListComponent {
    companion object {
        fun create(context: Context): MeasurementsListComponent {
            return DaggerMeasurementsListComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent).build()
        }
    }

    fun inject(fragment: MeasurementsListFragment)
}