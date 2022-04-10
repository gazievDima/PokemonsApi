package com.gaziev.pokemons.ui.screens.statistic

import android.view.LayoutInflater
import android.view.ViewGroup
import com.gaziev.pokemons.databinding.FragmentStaticsticBinding
import com.gaziev.pokemons.ui.common.fragments.BaseFragment
import com.gaziev.pokemons.ui.common.fragments.IBottomNavigationFragment
import com.gaziev.pokemons.ui.common.fragments.IToolbarFragment

class StatisticFragment : BaseFragment<FragmentStaticsticBinding>(), IToolbarFragment, IBottomNavigationFragment {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStaticsticBinding = FragmentStaticsticBinding::inflate
}