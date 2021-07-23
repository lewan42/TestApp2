package dev.fabula.android.support.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao
import dev.fabula.android.bridge.crossing.di.BridgeCrossingDaoModule
import dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao
import dev.fabula.android.measurements.type.di.MeasurementTypeDaoModule
import dev.fabula.android.platform.di.PlatformDaoModule
import dev.fabula.android.support.ui.SupportFragment
import dev.fabula.android.wire.carrier.di.CarrierWireDaoModule
import dev.fabula.android.wire.contact.di.ContactWireDaoModule

@Component(
    modules = [
        SupportModule::class,
        SupportDaoModule::class,
        SupportApiModule::class,
        PlatformDaoModule::class,
        BridgeCrossingDaoModule::class,
        ContactWireDaoModule::class,
        CarrierWireDaoModule::class,
        MeasurementTypeDaoModule::class,
    CreateMeasurementsDaoModule::class
    ],
    dependencies = [AppComponent::class]
)
interface SupportComponent {
    companion object {
        fun create(context: Context): SupportComponent {
            return DaggerSupportComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent).build()
        }
    }

    fun inject(fragment: SupportFragment)
}