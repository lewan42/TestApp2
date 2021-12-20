package dev.fabula.android.measurements.lab.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.measurements.lab.ui.LabViewModel

@Module(includes = [ViewModelModule::class])
abstract class LabModule {

    @Binds
    @IntoMap
    @ViewModelKey(LabViewModel::class)
    abstract fun bind(viewModel: LabViewModel): ViewModel
}