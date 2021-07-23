package dev.fabula.android.onboarding

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.BaseFragment

class OnboardingFragment : BaseFragment(R.layout.onboarding_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.img_get_card).setOnClickListener {
            findNavController().navigate(R.id.action_onboarding_to_profile)
        }
    }
}