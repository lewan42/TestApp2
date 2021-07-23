package dev.fabula.android.section.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.railway.ui.RailwayViewModel
import dev.fabula.android.section.ui.RailwaySectionViewModel

@Module(includes = [ViewModelModule::class])
abstract class RailwaySectionModule {

    @Binds
    @IntoMap
    @ViewModelKey(RailwaySectionViewModel::class)
    abstract fun bind(viewModel: RailwaySectionViewModel): ViewModel
}