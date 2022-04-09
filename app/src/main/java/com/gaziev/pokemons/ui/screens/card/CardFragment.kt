package com.gaziev.pokemons.ui.screens.card

import android.view.LayoutInflater
import android.view.ViewGroup
import com.gaziev.pokemons.databinding.FragmentCardBinding
import com.gaziev.pokemons.ui.common.fragments.BaseFragment

class CardFragment : BaseFragment<FragmentCardBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCardBinding = FragmentCardBinding::inflate


}