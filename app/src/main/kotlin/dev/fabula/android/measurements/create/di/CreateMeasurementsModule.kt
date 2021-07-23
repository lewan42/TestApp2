package dev.fabula.android.measurements.create.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.measurements.create.ui.CreateMeasurementsViewModel

@Module(includes = [ViewModelModule::class])
abstract class CreateMeasurementsModule {

    @Binds
    @IntoMap
    @ViewModelKey(CreateMeasurementsViewModel::class)
    abstract fun bind(viewModel: CreateMeasurementsViewModel): ViewModel
}