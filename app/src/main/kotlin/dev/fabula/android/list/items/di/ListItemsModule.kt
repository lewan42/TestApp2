package dev.fabula.android.list.items.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.list.items.ui.ListItemsViewModel

@Module(includes = [ViewModelModule::class])
abstract class ListItemsModule {
    @Binds
    @IntoMap
    @ViewModelKey(ListItemsViewModel::class)
    abstract fun bind(viewModel: ListItemsViewModel): ViewModel
}