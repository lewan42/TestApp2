package dev.fabula.android.splash

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.BaseFragment
import dev.fabula.android.auth_old.AppAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.net.InetAddress
import javax.inject.Inject
import kotlin.math.sin

class SplashFragment :
    BaseFragment(R.layout.splash_fragment) {

    @Inject
    lateinit var auth: AppAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        SplashComponent.create(context)
            .inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {

            val isOnline = checkConnection(getString(R.string.build_props_api_url))
            val direction = if (isAuthorised()) {

                if (isOnline) {
                    R.id.action_splash_to_sync_fragment

                } else {
                    R.id.action_splash_to_railway
                }

            } else {
                R.id.action_splash_to_authorisation
            }
            findNavController().navigate(direction)
        }
    }


    private fun isAuthorised(): Boolean =
        auth.user != null

    private suspend fun checkConnection(url: String): Boolean =
        withContext(Dispatchers.IO) {
            try {
                val apiUrl = Uri.parse(url)
                InetAddress.getByName(apiUrl.host).isReachable(3 * 1000)
            } catch (error: Throwable) {
                Timber.w(error, "Check connection failed!"); false
            }
        }


    private suspend fun refreshData() {
        context?.also { RefreshDataWork.start(it) }
    }
}