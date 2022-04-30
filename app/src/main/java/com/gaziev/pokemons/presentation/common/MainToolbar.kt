package com.gaziev.pokemons.presentation.common

import android.view.View
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.gaziev.pokemons.presentation.MainActivity
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.ToolbarFavoriteIcon
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.ToolbarSearchIcon
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.ToolbarSortIcon
import com.google.android.material.appbar.MaterialToolbar

class MainToolbar(
    val toolbar: MaterialToolbar,
    private val activity: MainActivity
    ) {

    init {
        toolbar.setNavigationOnClickListener {
            activity.onBackPressed()
        }
    }

    fun setup(fragment: Fragment) {
        if (fragment is ToolbarFragment)
            toolbar.visibility = View.VISIBLE
        else toolbar.visibility = View.GONE

        toolbar.menu[0].isVisible = fragment is ToolbarSearchIcon
        toolbar.menu[1].isVisible = fragment is ToolbarSortIcon
        toolbar.menu[2].isVisible = fragment is ToolbarFavoriteIcon
    }

}