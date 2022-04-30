package com.gaziev.pokemons.presentation.screens.favorites.pager.common

import com.gaziev.pokemons.R
import com.google.android.material.appbar.MaterialToolbar

class PagerToolbarListener(
    private val toolbar: MaterialToolbar
) {

    fun setup(searchListener: () -> Unit, sortListener: () -> Unit) {
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    searchListener()
                    true
                }
                R.id.sort -> {
                    sortListener()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

}