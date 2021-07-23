package dev.fabula.android.profile.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Ldev/fabula/android/profile/di/ProfileComponent;", "", "inject", "", "fragment", "Ldev/fabula/android/profile/ui/ProfileFragment;", "Companion", "app_release"})
@dagger.Component(modules = {dev.fabula.android.synchronize.di.SyncModule.class, dev.fabula.android.synchronize.di.SyncApiModule.class, dev.fabula.android.profile.di.ProfileModule.class, dev.fabula.android.bluetooth.di.BluetoothModel.class, dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule.class, dev.fabula.android.measurements.create.di.CreateMeasurementsApiModule.class, dev.fabula.android.canopy.di.CanopyApiModule.class, dev.fabula.android.canopy.di.CanopyDaoModule.class, dev.fabula.android.station.peregon.di.StationPeregonModuleDao.class, dev.fabula.android.station.peregon.di.StationApiModule.class, dev.fabula.android.wire.contact.di.ContactWireDaoModule.class, dev.fabula.android.wire.contact.di.ContactWireApiModule.class, dev.fabula.android.wire.carrier.di.CarrierWireDaoModule.class, dev.fabula.android.dimensions.fence.di.DimensionsFenceApiModule.class, dev.fabula.android.dimensions.fence.di.DimensionsFenceDaoModule.class, dev.fabula.android.wire.carrier.di.CarrierWireDaoModule.class, dev.fabula.android.wire.carrier.di.CarrierWireApiModule.class, dev.fabula.android.platform.di.PlatformDaoModule.class, dev.fabula.android.platform.di.PlatformApiModule.class, dev.fabula.android.railway.di.RailwayDaoModule.class, dev.fabula.android.section.di.RailwaySectionDaoModule.class, dev.fabula.android.support.di.SupportDaoModule.class, dev.fabula.android.bridge.crossing.di.BridgeCrossingDaoModule.class, dev.fabula.android.measurements.type.di.MeasurementTypeDaoModule.class, dev.fabula.android.support.di.SupportApiModule.class, dev.fabula.android.bridge.crossing.di.BridgeApiModule.class}, dependencies = {dev.fabula.android.app.di.AppComponent.class})
public abstract interface ProfileComponent {
    public static final dev.fabula.android.profile.di.ProfileComponent.Companion Companion = null;
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.profile.ui.ProfileFragment fragment);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Ldev/fabula/android/profile/di/ProfileComponent$Companion;", "", "()V", "create", "Ldev/fabula/android/profile/di/ProfileComponent;", "context", "Landroid/content/Context;", "app_release"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final dev.fabula.android.profile.di.ProfileComponent create(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}