package dev.fabula.android.railway.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dev.fabula.android.app.db.AppRoomDatabase
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.railway.dao.RailwayDao
import dev.fabula.android.railway.ui.RailwayViewModel
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
abstract class RailwayModule {

    @Binds
    @IntoMap
    @ViewModelKey(RailwayViewModel::class)
    abstract fun bind(viewModel: RailwayViewModel): ViewModel
}