package com.gaziev.pokemons.ui.screens.favorites.pager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gaziev.pokemons.ui.screens.favorites.pager.az.AZFragment
import com.gaziev.pokemons.ui.screens.favorites.pager.health.HealthFragment
import com.gaziev.pokemons.ui.screens.favorites.pager.strong.StrongFragment

class FavoritesPagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> { AZFragment() }
            1 -> { StrongFragment() }
            else -> { HealthFragment() }
        }
    }
}