package dev.fabula.android.auth_old

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule

@Component(
    modules = [AuthModule::class],
    dependencies = [AppComponent::class]
)
interface AuthComponent {

    fun inject(fragment: AuthFragmentPhone)
    fun inject(fragment: AuthFragmentCode)

    companion object {

        fun create(context: Context): AuthComponent {
            return DaggerAuthComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent)
                .build()
        }
    }

}

@Module(includes = [ViewModelModule::class])
abstract class AuthModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel
}