package dev.fabula.android.bluetooth.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.bluetooth.ui.BluetoothFragment

@Component(
    modules = [BluetoothModel::class],
    dependencies = [AppComponent::class]
)
interface BluetoothComponent {

    companion object {
        fun create(context: Context): BluetoothComponent {
            return DaggerBluetoothComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent)
                .build()
        }
    }

    fun inject(fragment: BluetoothFragment)
}