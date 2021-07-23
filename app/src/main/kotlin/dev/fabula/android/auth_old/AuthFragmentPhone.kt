package dev.fabula.android.auth_old

import android.content.Context
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.event
import dev.fabula.android.app.ui.showError
import dev.fabula.android.databinding.AuthFragmentPhoneBinding
import io.michaelrocks.libphonenumber.android.NumberParseException
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class AuthFragmentPhone : ViewModelFragment<AuthFragmentPhoneBinding>(R.layout.auth_fragment_phone) {

    private val viewModel: AuthViewModel by activityViewModel()

    @Inject
    lateinit var phoneUtil: PhoneNumberUtil

    private lateinit var formattedNumber: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AuthComponent.create(context)
            .inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.validatePhone.event(viewLifecycleOwner) {
            tryCode()
        }
        viewModel.error.event(viewLifecycleOwner) {
            showError(it)
        }
        viewModel.progress.observe(viewLifecycleOwner) { progress ->
            binding?.progress?.isVisible = progress
            binding?.btnGetCard?.isEnabled = checkInput() && !progress
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AuthFragmentPhoneBinding.bind(view).apply {
            inputNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher())
            inputNumber.addTextChangedListener {
                binding?.btnGetCard?.isEnabled = checkInput()
            }
            inputNumber.setOnEditorActionListener { _, _, _ ->
                if (checkInput()) binding?.btnGetCard?.performClick(); false
            }
            btnGetCard.setOnClickListener {
                onClickGetCard()
            }
            checkApproveText.setOnClickListener {
                binding?.checkApprove?.toggle()
            }
            checkApprove.setOnCheckedChangeListener { _, isChecked ->
                binding?.btnGetCard?.isEnabled = checkInput()
            }
        }
    }

    private fun checkInput(): Boolean = binding?.let { binding ->
        if (binding.checkApprove.isChecked == false)
            return false
        if (binding.inputNumber.text.length < 11)
            return false
        return try {
            val phoneNumber =
                phoneUtil.parse(binding.inputNumber.text.toString(), Locale.getDefault().country)
            formattedNumber =
                phoneUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164)
            val isPossible = phoneUtil.isPossibleNumberForType(phoneNumber, PhoneNumberUtil.PhoneNumberType.MOBILE)
            val isValid = phoneUtil.isValidNumber(phoneNumber)
            Timber.d("formatted:$formattedNumber isPossible:$isPossible isValid:$isValid"); isValid
        } catch (error: NumberParseException) {
            Timber.d(error, "Phone number parse failed!"); false
        }
    } ?: false

    private fun onClickGetCard() {
        binding?.inputNumber?.error = null
        if (formattedNumber.isEmpty() || formattedNumber.isBlank()) {
            binding?.inputNumber?.error = getString(R.string.auth_phone_input_number)
            return
        }
        val agree = binding?.checkApprove?.isChecked == true
        viewLifecycleOwner.lifecycleScope.launch {
            Timber.d("phone $formattedNumber, agree $agree")
            viewModel.validatePhone(formattedNumber, agree)
        }
    }

    private fun tryCode() {
        findNavController().navigate(R.id.action_input_phone_to_auth_by_code)
    }
}