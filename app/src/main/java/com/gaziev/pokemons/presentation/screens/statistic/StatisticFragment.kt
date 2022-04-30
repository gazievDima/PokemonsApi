package com.gaziev.pokemons.presentation.screens.statistic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.FragmentStaticsticBinding
import com.gaziev.pokemons.presentation.MainActivity
import com.gaziev.pokemons.presentation.common.BaseFragment
import com.gaziev.pokemons.presentation.common.BottomNavigationFragment
import com.gaziev.pokemons.presentation.common.ToolbarFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.ToolbarFavoriteIcon

class StatisticFragment : BaseFragment<FragmentStaticsticBinding>(), ToolbarFragment,
    BottomNavigationFragment,
    ToolbarFavoriteIcon {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStaticsticBinding = FragmentStaticsticBinding::inflate
    private val actionToFavorite = StatisticFragmentDirections.actionStatisticFragmentToFavoriteFragment()

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    if (findNavController().currentDestination?.id != R.id.favoriteFragment)
                        findNavController().navigate(actionToFavorite)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}