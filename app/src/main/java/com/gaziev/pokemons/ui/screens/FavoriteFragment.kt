package com.gaziev.pokemons.ui.screens

import android.view.LayoutInflater
import android.view.ViewGroup
import com.gaziev.pokemons.databinding.FragmentFavoritesBinding
import com.gaziev.pokemons.ui.common.BaseFragment

class FavoriteFragment : BaseFragment<FragmentFavoritesBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFavoritesBinding = FragmentFavoritesBinding::inflate
}