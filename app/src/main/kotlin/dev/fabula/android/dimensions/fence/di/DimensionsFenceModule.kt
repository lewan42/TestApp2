package dev.fabula.android.dimensions.fence.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.dimensions.fence.ui.DimensionsFenceViewModule

@Module(includes = [ViewModelModule::class])
abstract class DimensionsFenceModule {

    @Binds
    @IntoMap
    @ViewModelKey(DimensionsFenceViewModule::class)
    abstract fun bind(viewModel: DimensionsFenceViewModule): ViewModel
}