package dev.fabula.android.bosch.otg.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.bosch.otg.ui.BoschOtgFragment

@Component(
    modules = [
        BoschOtgModule::class,
        BoschOtgModuleDataSource::class
    ],
    dependencies = [AppComponent::class]
)
interface BoschOtgComponent {
    companion object {
        fun create(context: Context): BoschOtgComponent {
            return DaggerBoschOtgComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent).build()
        }
    }

    fun inject(fragment: BoschOtgFragment)
}