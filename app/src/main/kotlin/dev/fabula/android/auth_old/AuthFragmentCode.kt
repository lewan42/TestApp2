package dev.fabula.android.auth_old

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.*
import dev.fabula.android.databinding.AuthFragmentCodeBinding
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.abs

class AuthFragmentCode : ViewModelFragment<AuthFragmentCodeBinding>(R.layout.auth_fragment_code) {

    private lateinit var retrySendTime: Date

    private val viewModel: AuthViewModel by activityViewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AuthComponent.create(context)
            .inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.validatePhone.event(viewLifecycleOwner) {
            onSendCode()
        }
        viewModel.validateCode.event(viewLifecycleOwner) {
            onCodeSuccess()
        }
        viewModel.error.event(viewLifecycleOwner) {
            binding?.inputNumber?.text = null
            showError(it)
        }
        viewModel.progress.observe(viewLifecycleOwner) { progress ->
            showProgress(progress)
        }
        onSendCode()
    }

    private fun showProgress(progress: Boolean) {
        binding?.progress?.isVisible = progress
        binding?.retryTimer?.isVisible = !progress
        binding?.btnRetry?.isEnabled = checkTimer() && !progress
        binding?.btnNext?.isEnabled = checkCode() && !progress
    }

    private fun onCodeSuccess() {
       // context?.also { RefreshTokenWork.start(it.applicationContext) }
        findNavController().navigate(R.id.action_auth_by_code_to_home, null,
            NavOptions.Builder().setPopUpTo(R.id.app_navigation, true).build())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AuthFragmentCodeBinding.bind(view).apply {
            inputNumber.addTextChangedListener {
                binding?.btnNext?.isEnabled = checkCode()
            }
            inputNumber.setOnEditorActionListener { _, _, _ ->
                if (checkCode()) binding?.btnNext?.performClick(); false
            }
            btnNext.setOnClickListener {
                onClickNext()
            }
            btnRetry.setOnClickListener {
                onClickRetry()
            }
        }
    }

    private fun checkTimer() : Boolean =
        Calendar.getInstance().time.after(retrySendTime)

    private fun onClickRetry() {
        binding?.retryTimer?.error = null
        if (checkTimer()) {
            viewModel.tryCode()
        } else {
            binding?.retryTimer?.error = getString(R.string.auth_code_retry_timer_wait)
            showMessage(R.string.auth_code_retry_timer_wait)
        }
    }

    private fun checkCode() : Boolean = binding?.let {
        binding?.inputNumber?.isDone
    }?: false

    private fun onClickNext() {
        hideKeyboard()
        binding?.inputNumber?.error = null
        val number = binding?.inputNumber?.unMasked
        if (number.isNullOrEmpty() || number.isNullOrBlank()) {
            binding?.inputNumber?.error = getString(R.string.auth_phone_input_code)
            return
        }
        Timber.d("code $number")
        viewModel.validateCode(number)
    }

    private fun onSendCode() {
        binding?.btnRetry?.isEnabled = false
        lifecycleScope.launch {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.MINUTE, 1)
            retrySendTime = calendar.time
            val ticker = ticker(1_000, 0)
            repeat(1 * 60) {
                ticker.receive()
                val ticks = newTimerTick(retrySendTime)
                binding?.retryTimer?.text = getString(R.string.auth_code_retry_timer, ticks)
            }
            ticker.cancel()
            binding?.retryTimer?.error = null
            binding?.retryTimer?.setText(R.string.auth_phone_input_code)
            binding?.btnRetry?.isEnabled = true
        }
    }

    private fun newTimerTick(next_task_time: Date): String {
        val calendar = Calendar.getInstance()
        val currentTime = calendar.time
        val diff = abs(currentTime.time - next_task_time.time)
        val min = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS)
        val sec = TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS)
        return "${min * 60}:${sec - min * 60}"
    }
}