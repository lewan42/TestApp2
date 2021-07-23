package dev.fabula.android.profile.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.profile.ui.ProfileViewModel

@Module(includes = [ViewModelModule::class])
abstract class ProfileModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindAuthViewModel(viewModel: ProfileViewModel): ViewModel
}