package dev.fabula.android.measurements.lab.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule
import dev.fabula.android.measurements.lab.ui.LabFragment

@Component(
    modules = [LabModule::class],
    dependencies = [AppComponent::class]
)
interface LabComponent {
    companion object {
        fun create(context: Context): LabComponent {
            return DaggerLabComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent).build()
        }
    }

    fun inject(fragment: LabFragment)
}