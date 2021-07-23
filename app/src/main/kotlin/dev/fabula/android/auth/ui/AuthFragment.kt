package dev.fabula.android.auth.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.event
import dev.fabula.android.app.ui.showError
import dev.fabula.android.app.ui.showMessage
import dev.fabula.android.auth.di.AuthComponent
import dev.fabula.android.auth_old.Unauthorised
import dev.fabula.android.databinding.AuthFragmentBinding

class AuthFragment : ViewModelFragment<AuthFragmentBinding>(R.layout.auth_fragment) {

    private val viewModel: AuthViewModel by activityViewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AuthComponent.create(context).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = AuthFragmentBinding.bind(view).apply {

            viewModel.error.event(viewLifecycleOwner) {
                showError(Unauthorised())
                progressBar.visibility = View.GONE
            }

            viewModel.singIn.event(viewLifecycleOwner) {
                if (it) {
                    findNavController().navigate(R.id.action_auth_to_sync_fragment)
                }
            }
            btnSingIn.setOnClickListener(::singIn)
        }
    }

    private fun singIn(view: View) {
        binding?.apply {
            if (email.text.isNullOrEmpty() || password.text.isNullOrEmpty()) {
                showMessage(R.string.fill_in_all_fields)
                return
            }
            progressBar.visibility = View.VISIBLE
            Log.e("AuthFragment ","singIn")
            viewModel.trySingIn(email.text.toString(), password.text.toString())
        }
    }
}
