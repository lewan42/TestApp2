package dev.fabula.android.measurements.union.list.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.bosch.otg.di.BoschOtgModuleDataSource
import dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule
import dev.fabula.android.measurements.union.list.ui.UnionMeasurementsListFragment

@Component(
    modules = [
        UnionMeasurementListModule::class,
        CreateMeasurementsDaoModule::class,
        BoschOtgModuleDataSource::class
    ], dependencies = [AppComponent::class]
)
interface UnionMeasurementsListComponent {
    companion object {
        fun create(context: Context): UnionMeasurementsListComponent {
            return DaggerUnionMeasurementsListComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent).build()
        }
    }

    fun inject(fragment: UnionMeasurementsListFragment)
}