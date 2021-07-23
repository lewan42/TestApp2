package dev.fabula.android.bridge.crossing.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.bridge.crossing.ui.BridgeCrossingFragment
import dev.fabula.android.platform.di.PlatformDaoModule
import dev.fabula.android.support.di.SupportDaoModule

@Component(
    modules = [
        BridgeModule::class,
        PlatformDaoModule::class,
        SupportDaoModule::class,
    BridgeCrossingDaoModule::class
    ],
    dependencies = [AppComponent::class]
)
interface BridgeComponent {

    companion object {
        fun create(context: Context): BridgeComponent {
            return DaggerBridgeComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent)
                .build()
        }
    }

    fun inject(fragment: BridgeCrossingFragment)
}