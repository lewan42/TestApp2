package dev.fabula.android.devices.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.devices.ui.DevicesViewModel

@Module(includes = [ViewModelModule::class])
abstract class DevicesModule {

    @Binds
    @IntoMap
    @ViewModelKey(DevicesViewModel::class)
    abstract fun bind(viewModel: DevicesViewModel): ViewModel
}