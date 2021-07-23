package dev.fabula.android.app.ui

import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

fun ViewPager.addOnPageChangeListener(listener: (Int)-> Unit) =
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            when (positionOffset) {
                0f -> listener.invoke(position)
            }
        }

        override fun onPageSelected(position: Int) {
        }
    })

fun ViewPager2.addOnPageChangeListener(listener: (Int)-> Unit) =
    registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            when (positionOffset) {
                0f -> listener.invoke(position)
            }
        }
    })