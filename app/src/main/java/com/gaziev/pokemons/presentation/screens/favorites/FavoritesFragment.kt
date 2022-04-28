package com.gaziev.pokemons.presentation.screens.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.gaziev.pokemons.databinding.FragmentFavoritesBinding
import com.gaziev.pokemons.presentation.common.BaseFragment
import com.gaziev.pokemons.presentation.common.ToolbarFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.FavoritesPagerAdapter
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.ToolbarSearchIcon
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.ToolbarSortIcon
import com.google.android.material.tabs.TabLayout

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>(), ToolbarFragment,
    ToolbarSearchIcon, ToolbarSortIcon {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFavoritesBinding =
        FragmentFavoritesBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = FavoritesPagerAdapter(this)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = tab?.position!!
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

    }

}