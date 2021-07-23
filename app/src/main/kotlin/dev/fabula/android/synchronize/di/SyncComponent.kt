package dev.fabula.android.synchronize.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.auth.di.AuthApiModule
import dev.fabula.android.auth.di.AuthComponent
import dev.fabula.android.auth.di.AuthModule
import dev.fabula.android.auth.di.DaggerAuthComponent
import dev.fabula.android.auth.ui.AuthFragment
import dev.fabula.android.bridge.crossing.di.BridgeApiModule
import dev.fabula.android.bridge.crossing.di.BridgeCrossingDaoModule
import dev.fabula.android.canopy.di.CanopyApiModule
import dev.fabula.android.canopy.di.CanopyDaoModule
import dev.fabula.android.dimensions.fence.di.DimensionsFenceApiModule
import dev.fabula.android.dimensions.fence.di.DimensionsFenceDaoModule
import dev.fabula.android.measurements.create.di.CreateMeasurementsApiModule
import dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule
import dev.fabula.android.measurements.type.di.MeasurementTypeDaoModule
import dev.fabula.android.platform.di.PlatformApiModule
import dev.fabula.android.platform.di.PlatformDaoModule
import dev.fabula.android.railway.di.RailwayDaoModule
import dev.fabula.android.section.di.RailwaySectionDaoModule
import dev.fabula.android.station.peregon.di.StationApiModule
import dev.fabula.android.station.peregon.di.StationPeregonModuleDao
import dev.fabula.android.support.di.SupportApiModule
import dev.fabula.android.support.di.SupportDaoModule
import dev.fabula.android.synchronize.ui.SyncFragment
import dev.fabula.android.wire.carrier.di.CarrierWireApiModule
import dev.fabula.android.wire.carrier.di.CarrierWireDaoModule
import dev.fabula.android.wire.contact.di.ContactWireApiModule
import dev.fabula.android.wire.contact.di.ContactWireDaoModule

@Component(
    modules = [
        SyncModule::class,
        AuthApiModule::class,
        SyncApiModule::class,
        RailwayDaoModule::class,
        RailwaySectionDaoModule::class,
        StationPeregonModuleDao::class,
        SupportDaoModule::class,
        PlatformDaoModule::class,
        CreateMeasurementsDaoModule::class,
        BridgeCrossingDaoModule::class,
        DimensionsFenceDaoModule::class,
        CanopyDaoModule::class,
        ContactWireDaoModule::class,
        CarrierWireDaoModule::class,
        StationApiModule::class,
        MeasurementTypeDaoModule::class,
        PlatformApiModule::class,
        CreateMeasurementsApiModule::class,
        DimensionsFenceApiModule::class,
        ContactWireApiModule::class,
        CarrierWireApiModule::class,
        CanopyApiModule::class,
        StationApiModule::class,
        SupportApiModule::class,
        BridgeApiModule::class
    ],
    dependencies = [AppComponent::class]
)
interface SyncComponent {
    companion object {
        fun create(context: Context): SyncComponent {
            return DaggerSyncComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent)
                .build()
        }
    }

    fun inject(fragment: SyncFragment)
}