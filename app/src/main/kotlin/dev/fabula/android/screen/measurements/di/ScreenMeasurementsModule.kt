package dev.fabula.android.screen.measurements.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.screen.measurements.ui.ScreenMeasurementsViewModule

@Module(includes = [ViewModelModule::class])
abstract class ScreenMeasurementsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ScreenMeasurementsViewModule::class)
    abstract fun bind(viewModel: ScreenMeasurementsViewModule): ViewModel
}