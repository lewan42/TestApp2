package dev.fabula.android.platform.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.canopy.di.CanopyDaoModule
import dev.fabula.android.platform.ui.PlatformFragment
import dev.fabula.android.support.di.SupportDaoModule

@Component(
    modules = [
        PlatformModule::class,
        PlatformDaoModule::class,
        CanopyDaoModule::class,
        SupportDaoModule::class
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