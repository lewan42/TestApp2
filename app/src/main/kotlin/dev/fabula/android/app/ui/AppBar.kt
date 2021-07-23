package dev.fabula.android.app.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R

fun Fragment.setTitle(@StringRes titleId: Int) {
    view?.findViewById<TextView>(R.id.appbar_title_text)?.setText(titleId)
    view?.findViewById<ImageView>(R.id.appbar_home_bth)?.setOnClickListener {
        findNavController().navigateUp()
    }
}

fun Fragment.setTitle(title: String) {
    view?.findViewById<TextView>(R.id.appbar_title_text)?.text = title
    view?.findViewById<ImageView>(R.id.appbar_home_bth)?.setOnClickListener {
        findNavController().navigateUp()
    }
}