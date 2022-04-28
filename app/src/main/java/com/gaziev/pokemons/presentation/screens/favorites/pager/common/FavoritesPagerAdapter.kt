package com.gaziev.pokemons.presentation.screens.favorites.pager.common

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gaziev.pokemons.presentation.screens.favorites.pager.latest.LatestFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.health.HealthFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.names.NamesFragment

class FavoritesPagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> { LatestFragment() }
            1 -> { NamesFragment() }
            else -> { HealthFragment() }
        }
    }
}