package dev.fabula.android.app

import android.app.Application
import dev.fabula.android.BuildConfig
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.app.timber.LoggingAndCrashes

class BaseApp : Application() {

    val appComponent: AppComponent by lazy {
        AppComponent.create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()


        LoggingAndCrashes.init(BuildConfig.DEBUG)
    }
}