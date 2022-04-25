package com.gaziev.pokemons.presentation.screens.splash

import android.view.LayoutInflater
import android.view.ViewGroup
import com.gaziev.pokemons.databinding.FragmentSplashBinding
import com.gaziev.pokemons.presentation.common.BaseFragment

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSplashBinding = FragmentSplashBinding::inflate
}