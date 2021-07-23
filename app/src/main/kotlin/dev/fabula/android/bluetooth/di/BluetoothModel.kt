package dev.fabula.android.bluetooth.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.bluetooth.ui.BluetoothViewModel

@Module(includes = [ViewModelModule::class])
abstract class BluetoothModel {

    @Binds
    @IntoMap
    @ViewModelKey(BluetoothViewModel::class)
    abstract fun bind(viewModel: BluetoothViewModel): ViewModel
}