package dev.fabula.android.canopy.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.canopy.ui.CanopyViewModel
import dev.fabula.android.dimensions.fence.ui.DimensionsFenceViewModule

@Module(includes = [ViewModelModule::class])
abstract class CanopyModule {

    @Binds
    @IntoMap
    @ViewModelKey(CanopyViewModel::class)
    abstract fun bind(viewModel: CanopyViewModel): ViewModel
}