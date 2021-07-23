package dev.fabula.android.support.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.support.ui.SupportViewModule

@Module(includes = [ViewModelModule::class])
abstract class SupportModule {

    @Binds
    @IntoMap
    @ViewModelKey(SupportViewModule::class)
    abstract fun bind(viewModel: SupportViewModule): ViewModel
}