package dev.fabula.android.splash

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent

@Component(
    dependencies = [AppComponent::class]
)
interface SplashComponent {

    fun inject(fragment: SplashFragment)
    fun inject(fragment: RefreshDataWork)

    companion object {

        fun create(context: Context): SplashComponent {
            return DaggerSplashComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent)
                .build()
        }
    }
}