package dev.fabula.android.devices.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.devices.ui.DevicesFragment

@Component(
    modules = [DevicesModule::class],
    dependencies = [AppComponent::class]
)
interface DevicesComponent {

    companion object {
        fun create(context: Context): DevicesComponent {
            return DaggerDevicesComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent)
                .build()
        }
    }

    fun inject(fragment: DevicesFragment)
}