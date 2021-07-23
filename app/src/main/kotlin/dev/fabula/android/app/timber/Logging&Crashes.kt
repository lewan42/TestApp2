package dev.fabula.android.app.timber

import timber.log.Timber

object LoggingAndCrashes {

    fun init(debug: Boolean) {
        if (debug) {
            Timber.plant(Timber.DebugTree())
        }
    }
}