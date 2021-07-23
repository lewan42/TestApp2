package dev.fabula.android.station.peregon.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.station.peregon.ui.StationPeregonViewModule

@Module(includes = [ViewModelModule::class])
abstract class StationPeregonModule {

    @Binds
    @IntoMap
    @ViewModelKey(StationPeregonViewModule::class)
    abstract fun bind(viewModel: StationPeregonViewModule): ViewModel
}