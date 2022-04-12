package com.gaziev.pokemons.ui.screens.statistic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.FragmentStaticsticBinding
import com.gaziev.pokemons.ui.MainActivity
import com.gaziev.pokemons.ui.common.fragments.BaseFragment
import com.gaziev.pokemons.ui.common.fragments.IBottomNavigationFragment
import com.gaziev.pokemons.ui.common.fragments.IToolbarFragment
import com.gaziev.pokemons.ui.common.fragments.toolbar.IToolbarFavoriteIcon

class StatisticFragment : BaseFragment<FragmentStaticsticBinding>(), IToolbarFragment, IBottomNavigationFragment, IToolbarFavoriteIcon {
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