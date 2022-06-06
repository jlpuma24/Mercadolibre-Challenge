package com.melichallenge.presentation.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.melichallenge.domain.model.Review
import com.melichallenge.presentation.view.fragments.AllOpinionsFragment
import com.melichallenge.presentation.view.fragments.NegativeOpinionsFragment
import com.melichallenge.presentation.view.fragments.PositiveOpinionsFragment

const val TABS_NUMBER = 3

class OpinionsViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val reviews: ArrayList<Review>?
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return TABS_NUMBER
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllOpinionsFragment().newInstance(reviews)
            1 -> PositiveOpinionsFragment().newInstance(reviews?.filter { it.rate in 4.0..5.0 } as ArrayList<Review>)
            else -> NegativeOpinionsFragment().newInstance(reviews?.filter { it.rate < 3.0 } as ArrayList<Review>)
        }
    }
}