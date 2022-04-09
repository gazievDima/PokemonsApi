package com.gaziev.pokemons.ui.screens.statistic

import android.view.LayoutInflater
import android.view.ViewGroup
import com.gaziev.pokemons.databinding.FragmentStaticsticBinding
import com.gaziev.pokemons.ui.common.fragments.BaseFragment
import com.gaziev.pokemons.ui.common.fragments.BottomNavigationFragment
import com.gaziev.pokemons.ui.common.fragments.ToolbarFragment

class StatisticFragment : BaseFragment<FragmentStaticsticBinding>(), ToolbarFragment, BottomNavigationFragment {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStaticsticBinding = FragmentStaticsticBinding::inflate
}