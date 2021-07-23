package dev.fabula.android.measurements.list.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.measurements.list.ui.MeasurementsListViewModel

@Module(includes = [ViewModelModule::class])
abstract class MeasurementListModule {

    @Binds
    @IntoMap
    @ViewModelKey(MeasurementsListViewModel::class)
    abstract fun bind(viewModel: MeasurementsListViewModel): ViewModel
}