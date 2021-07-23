package dev.fabula.android.support.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Ldev/fabula/android/support/di/SupportComponent;", "", "inject", "", "fragment", "Ldev/fabula/android/support/ui/SupportFragment;", "Companion", "app_debug"})
@dagger.Component(modules = {dev.fabula.android.support.di.SupportModule.class, dev.fabula.android.support.di.SupportDaoModule.class, dev.fabula.android.support.di.SupportApiModule.class, dev.fabula.android.platform.di.PlatformDaoModule.class, dev.fabula.android.bridge.crossing.di.BridgeCrossingDaoModule.class, dev.fabula.android.wire.contact.di.ContactWireDaoModule.class, dev.fabula.android.wire.carrier.di.CarrierWireDaoModule.class, dev.fabula.android.measurements.type.di.MeasurementTypeDaoModule.class, dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule.class}, dependencies = {dev.fabula.android.app.di.AppComponent.class})
public abstract interface SupportComponent {
    public static final dev.fabula.android.support.di.SupportComponent.Companion Companion = null;
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.support.ui.SupportFragment fragment);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Ldev/fabula/android/support/di/SupportComponent$Companion;", "", "()V", "create", "Ldev/fabula/android/support/di/SupportComponent;", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final dev.fabula.android.support.di.SupportComponent create(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}