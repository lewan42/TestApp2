package dev.fabula.android.station.peregon.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.station.peregon.ui.StationPeregonFragment

@Component(
    modules = [
        StationPeregonModule::class,
        StationPeregonModuleDao::class
    ],
    dependencies = [AppComponent::class]
)
interface StationPeregonComponent {

    companion object {
        fun create(context: Context): StationPeregonComponent {
            return DaggerStationPeregonComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent)
                .build()
        }
    }

    fun inject(fragment: StationPeregonFragment)
}