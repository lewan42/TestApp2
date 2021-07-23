package dev.fabula.android.bosch.otg.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.bosch.otg.ui.BoschOtgViewModule


@Module(includes = [ViewModelModule::class])
abstract class BoschOtgModule {

    @Binds
    @IntoMap
    @ViewModelKey(BoschOtgViewModule::class)
    abstract fun bind(viewModel: BoschOtgViewModule): ViewModel
}