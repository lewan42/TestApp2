package dev.fabula.android.app.ui

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.snackbar.Snackbar

fun Snackbar.subscribeToLifecycleEvents(
    lifecycleOwner: LifecycleOwner?,
    dismissHandler: (() -> Unit)? = null
): Snackbar {
    val lifecycleObserver = LifecycleEventObserver { _, event ->
        if (this.isShown && event in listOf(
                Lifecycle.Event.ON_PAUSE,
                Lifecycle.Event.ON_STOP,
                Lifecycle.Event.ON_DESTROY
            )
        ) {
            this.dismiss()
            dismissHandler?.invoke()
        }
    }

    lifecycleOwner?.apply { this.lifecycle.addObserver(lifecycleObserver) }
    return this.addOnDismissedCallback { _, _ ->
        lifecycleOwner?.apply { this.lifecycle.removeObserver(lifecycleObserver) }
    }
}

fun Snackbar.addOnDismissedCallback(callback: (snackbar: Snackbar?, event: Int) -> Unit) =
    this.addCallback(object : Snackbar.Callback() {
        override fun onShown(sb: Snackbar?) {

        }

        override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
            callback.invoke(transientBottomBar, event)
        }
    })