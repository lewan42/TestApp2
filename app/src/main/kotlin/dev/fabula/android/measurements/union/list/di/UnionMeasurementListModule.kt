package dev.fabula.android.measurements.union.list.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.measurements.union.list.ui.UnionMeasurementsListViewModel

@Module(includes = [ViewModelModule::class])
abstract class UnionMeasurementListModule {

    @Binds
    @IntoMap
    @ViewModelKey(UnionMeasurementsListViewModel::class)
    abstract fun bind(viewModel: UnionMeasurementsListViewModel): ViewModel
}