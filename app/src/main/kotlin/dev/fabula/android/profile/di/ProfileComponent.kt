package dev.fabula.android.profile.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.bluetooth.di.BluetoothModel
import dev.fabula.android.bridge.crossing.di.BridgeApiModule
import dev.fabula.android.bridge.crossing.di.BridgeCrossingDaoModule
import dev.fabula.android.canopy.di.CanopyApiModule
import dev.fabula.android.canopy.di.CanopyDaoModule
import dev.fabula.android.dimensions.fence.di.DimensionsFenceApiModule
import dev.fabula.android.dimensions.fence.di.DimensionsFenceDaoModule
import dev.fabula.android.measurements.create.di.CreateMeasurementsApiModule
import dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule
import dev.fabula.android.measurements.type.di.MeasurementTypeDaoModule
import dev.fabula.android.platform.dao.PlatformDao
import dev.fabula.android.platform.di.PlatformApiModule
import dev.fabula.android.platform.di.PlatformDaoModule
import dev.fabula.android.profile.ui.ProfileFragment
import dev.fabula.android.railway.di.RailwayDaoModule
import dev.fabula.android.section.di.RailwaySectionDaoModule
import dev.fabula.android.station.peregon.di.StationApiModule
import dev.fabula.android.station.peregon.di.StationPeregonModuleDao
import dev.fabula.android.support.di.SupportApiModule
import dev.fabula.android.support.di.SupportDaoModule
import dev.fabula.android.synchronize.di.SyncApiModule
import dev.fabula.android.synchronize.di.SyncModule
import dev.fabula.android.wire.carrier.di.CarrierWireApiModule
import dev.fabula.android.wire.carrier.di.CarrierWireDaoModule
import dev.fabula.android.wire.contact.api.ContactWireApi
import dev.fabula.android.wire.contact.di.ContactWireApiModule
import dev.fabula.android.wire.contact.di.ContactWireDaoModule

@Component(
    modules = [
        SyncModule::class,
        SyncApiModule::class,
        ProfileModule::class,
        BluetoothModel::class,
        CreateMeasurementsDaoModule::class,
        CreateMeasurementsApiModule::class,
        CanopyApiModule::class,
        CanopyDaoModule::class,
        StationPeregonModuleDao::class,
        StationApiModule::class,
        ContactWireDaoModule::class,
        ContactWireApiModule::class,
        CarrierWireDaoModule::class,
        DimensionsFenceApiModule::class,
        DimensionsFenceDaoModule::class,
        CarrierWireDaoModule::class,
        CarrierWireApiModule::class,
        PlatformDaoModule::class,
        PlatformApiModule::class,
        RailwayDaoModule::class,
        RailwaySectionDaoModule::class,
        SupportDaoModule::class,
        BridgeCrossingDaoModule::class,
        MeasurementTypeDaoModule::class,
        SupportApiModule::class,
        BridgeApiModule::class
    ],
    dependencies = [AppComponent::class]
)
interface ProfileComponent {

    fun inject(fragment: ProfileFragment)

    companion object {
        fun create(context: Context): ProfileComponent {
            return DaggerProfileComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent)
                .build()
        }
    }
}