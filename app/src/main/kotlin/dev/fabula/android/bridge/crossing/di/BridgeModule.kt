package dev.fabula.android.bridge.crossing.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.bridge.crossing.ui.BridgeViewModule

@Module(includes = [ViewModelModule::class])
abstract class BridgeModule {

    @Binds
    @IntoMap
    @ViewModelKey(BridgeViewModule::class)
    abstract fun bind(viewModel: BridgeViewModule): ViewModel
}