package dev.fabula.android.app.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Reusable
import dev.fabula.android.app.ui.AppActivity
import dev.fabula.android.auth_old.AppAuth
import dev.fabula.android.splash.SplashFragment

@Component(
    modules = [
        PhoneModule::class,
        GlideModule::class,
        GsonModule::class,
        NetworkModule::class,
        DatabaseModule::class
    ]
)

interface AppComponent : PhoneProvider,
    NetworkProvider, GlideProvider,
    DatabaseProvider {

    fun inject(activity: AppActivity)

    fun inject(fragment: SplashFragment)

    fun provideContext(): Context

    @Reusable
    fun provideAuth(): AppAuth

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: Context): Builder
        fun build(): AppComponent
    }

    companion object {
        fun create(context: Context): AppComponent {
            return DaggerAppComponent.builder()
                .application(context)
                .build()
        }
    }
}