package com.gaziev.pokemons.ui.screens.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.gaziev.pokemons.databinding.FragmentFavoritesBinding
import com.gaziev.pokemons.ui.common.fragments.BaseFragment
import com.gaziev.pokemons.ui.common.fragments.IToolbarFragment
import com.gaziev.pokemons.ui.common.fragments.toolbar.IToolbarSearchIcon
import com.gaziev.pokemons.ui.common.fragments.toolbar.IToolbarSortIcon
import com.gaziev.pokemons.ui.screens.favorites.pager.FavoritesPagerAdapter
import com.google.android.material.tabs.TabLayout

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>(), IToolbarFragment,
    IToolbarSearchIcon, IToolbarSortIcon {
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