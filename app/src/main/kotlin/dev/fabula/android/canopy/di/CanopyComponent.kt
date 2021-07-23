package dev.fabula.android.canopy.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.canopy.ui.CanopyFragment
import dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule

@Component(
    modules = [CanopyModule::class,
        CanopyDaoModule::class,
        CreateMeasurementsDaoModule::class
    ],
    dependencies = [AppComponent::class]
)
interface CanopyComponent {
    companion object {
        fun create(context: Context): CanopyComponent {
            return DaggerCanopyComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent).build()
        }
    }

    fun inject(fragment: CanopyFragment)
}