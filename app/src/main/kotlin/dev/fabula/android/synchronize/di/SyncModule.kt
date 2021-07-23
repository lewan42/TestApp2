package dev.fabula.android.synchronize.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.synchronize.ui.SyncViewModule

@Module(includes = [ViewModelModule::class])
abstract class SyncModule {

    @Binds
    @IntoMap
    @ViewModelKey(SyncViewModule::class)
    abstract fun bind(viewModel: SyncViewModule): ViewModel
}