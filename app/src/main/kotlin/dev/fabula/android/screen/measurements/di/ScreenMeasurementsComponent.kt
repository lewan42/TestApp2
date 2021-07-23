package dev.fabula.android.screen.measurements.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.screen.measurements.ui.ScreenMeasurementsFragment
import dev.fabula.android.station.peregon.di.StationPeregonModuleDao
import dev.fabula.android.support.di.SupportDaoModule

@Component(
    modules = [
        ScreenMeasurementsModule::class,
        StationPeregonModuleDao::class,
        SupportDaoModule::class
    ],
    dependencies = [AppComponent::class]
)
interface ScreenMeasurementsComponent {

    companion object {
        fun create(context: Context): ScreenMeasurementsComponent {
            return DaggerScreenMeasurementsComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent).build()
        }
    }

    fun inject(fragment: ScreenMeasurementsFragment)
}