package com.gaziev.pokemons.presentation.screens.pokemons

import com.gaziev.pokemons.R
import com.google.android.material.appbar.MaterialToolbar

class PokemonsToolbarListener(
    private val toolbar: MaterialToolbar
) {

    fun setup(favoriteListener: () -> Unit) {
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                  favoriteListener()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}