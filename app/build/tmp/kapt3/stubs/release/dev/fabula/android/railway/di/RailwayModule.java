package dev.fabula.android.railway.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Ldev/fabula/android/railway/di/RailwayModule;", "", "()V", "bind", "Landroidx/lifecycle/ViewModel;", "viewModel", "Ldev/fabula/android/railway/ui/RailwayViewModel;", "app_release"})
@dagger.Module(includes = {dev.fabula.android.app.di.ViewModelModule.class})
public abstract class RailwayModule {
    
    @org.jetbrains.annotations.NotNull()
    @dev.fabula.android.app.di.ViewModelKey(value = dev.fabula.android.railway.ui.RailwayViewModel.class)
    @dagger.multibindings.IntoMap()
    @dagger.Binds()
    public abstract androidx.lifecycle.ViewModel bind(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.railway.ui.RailwayViewModel viewModel);
    
    public RailwayModule() {
        super();
    }
}