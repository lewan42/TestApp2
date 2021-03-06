package dev.fabula.android.app.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import dev.fabula.android.R
import timber.log.Timber
import javax.inject.Inject

abstract class BaseFragment : Fragment {

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDetach() {
        super.onDetach()
    }

}

abstract class ViewBindingFragment<V : ViewBinding> : BaseFragment {

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    protected var binding: V? = null

    override fun onDestroyView() {
        super.onDestroyView()
        view?.post {
            Timber.d("binding release ${binding?.let { it::class.simpleName }}"); binding = null
        }
    }

}

abstract class ViewModelFragment<V : ViewBinding> : ViewBindingFragment<V> {

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected inline fun <reified VM : ViewModel> activityViewModel(): Lazy<VM> =
        activityViewModels { viewModelFactory }

    protected inline fun <reified VM : ViewModel> viewModel(): Lazy<VM> =
        viewModels { viewModelFactory }

}

abstract class ViewModelChildFragment<V : ViewBinding> : ViewBindingFragment<V> {

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    protected inline fun <reified VM : ViewModel> activityViewModel(): Lazy<VM> =
        activityViewModels { (requireParentFragment() as ViewModelFragment<*>).viewModelFactory }

    protected inline fun <reified VM : ViewModel> viewModel(): Lazy<VM> =
        viewModels { (requireParentFragment() as ViewModelFragment<*>).viewModelFactory }

    protected inline fun <reified VM : ViewModel> parentViewModel(): Lazy<VM> =
        viewModels(
            { requireParentFragment() },
            { (requireParentFragment() as ViewModelFragment<*>).viewModelFactory })
}

fun Fragment.showMessage(@StringRes message: Int) {
    activity?.let {
        AlertDialog.Builder(it)
            .setMessage(message)
            .setNeutralButton(R.string.action_close, null)
            .show()
    }
}

fun Fragment.showError(error: Throwable) {
    if (lifecycle.currentState != Lifecycle.State.RESUMED)
        return
    activity?.let {
        AlertDialog.Builder(it)
            .apply {
                when (error.localizedMessageResId) {
                    -1 -> setMessage(error.localizedMessage)
                    else -> setMessage(error.localizedMessageResId)
                }
            }
            .setNeutralButton(R.string.action_close, null)
            .show()
    }
}

fun Fragment.showToast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) {
    context?.let {
        Toast.makeText(it, message, duration).show()
    }
}