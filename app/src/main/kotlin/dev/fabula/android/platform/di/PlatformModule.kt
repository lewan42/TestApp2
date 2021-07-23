package dev.fabula.android.platform.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.platform.ui.PlatformViewModule

@Module(includes = [ViewModelModule::class])
abstract class PlatformModule {

    @Binds
    @IntoMap
    @ViewModelKey(PlatformViewModule::class)
    abstract fun bind(viewModel: PlatformViewModule): ViewModel
}