package com.example.fixturesapplication.view.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.domain.useCases.getMatches.GetMatchesStrategy
import com.example.fixturesapplication.R
import com.example.fixturesapplication.view.MatchesFragment

class HomePagerAdapter(fragmentManager: FragmentManager, private val context: Context) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MatchesFragment.newInstance()
            1 -> MatchesFragment.newInstance(GetMatchesStrategy.Factory.Type.FAVORITE)
            else -> MatchesFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> context.getString(R.string.matches_label)
            1 -> context.getString(R.string.favorite_label)
            else -> context.getString(R.string.matches_label)
        }
    }

    override fun getCount(): Int {
        return 2
    }
}