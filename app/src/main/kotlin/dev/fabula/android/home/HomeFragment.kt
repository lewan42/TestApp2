package dev.fabula.android.home

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import dev.fabula.android.R
import dev.fabula.android.app.ui.ViewBindingFragment
import dev.fabula.android.app.ui.addOnPageChangeListener
import dev.fabula.android.databinding.HomeFragmentBinding

class HomeFragment() : ViewBindingFragment<HomeFragmentBinding>(R.layout.home_fragment) {

    constructor(pagePosition: Int) : this() {
        this.arguments = Bundle().apply {
            putInt("page_position", pagePosition)
        }
    }

    private val pagePosition get() = arguments?.getInt("page_position", 0)

    enum class Pages(val position: Int) {
        NEWS(0), SALE(1)
    }

    private val navButtons = mutableListOf<Button>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navButtons.clear()
        binding = HomeFragmentBinding.bind(view).apply {
            groupButtons.referencedIds.forEach { itemId ->
                view.findViewById<View>(itemId)
                    .takeIf { it is Button }
                    ?.apply {
                        navButtons.add(this as Button)
                        this.setOnClickListener(::onClickNavButton)
                    }
            }
            pageList.addOnPageChangeListener { onShowPage(it) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        navButtons.clear()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding?.pageList?.adapter = HomePagesAdapter(childFragmentManager)
        showPage(Pages.values().firstOrNull { it.position == pagePosition }?.position?: Pages.NEWS.position)
    }

    private fun onShowPage(position: Int) {
        val colorNormal = ContextCompat.getColor(requireContext(), R.color.color_text_secondary)
        val colorActive = ContextCompat.getColor(requireContext(), R.color.color_text_primary)
        for (i in navButtons.indices) {
            if (i == position)
                navButtons[i].setTextColor(colorActive)
            else
                navButtons[i].setTextColor(colorNormal)
        }
    }

    private fun onClickNavButton(view: View) {
        val position = navButtons.indexOf(view)
        showPage(position)
    }

    private fun showPage(position: Int) {
        binding?.pageList?.currentItem = position
    }

    inner class HomePagesAdapter(
        fragmentManager: FragmentManager
    ) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment {
            return when(position) {
                Pages.NEWS.position -> TemplateFragment("news")
                Pages.SALE.position -> TemplateFragment("sale")
                else -> throw IllegalArgumentException("Error! Unknown home page Id!")
            }
        }

        override fun getCount(): Int = Pages.values().size
    }

}

class TemplateFragment(
    val title: String
): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return TextView(inflater.context).apply {
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            gravity = Gravity.CENTER
            text = title
        }
    }
}