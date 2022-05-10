package com.gaziev.pokemons.presentation.common

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.gaziev.pokemons.presentation.screens.common.BottomNavigationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainBottomNavigation(
    private val bottomNavigation: BottomNavigationView,
    navController: NavController
) {

    init {
        bottomNavigation.setupWithNavController(navController)
    }

    fun setup(fragment: Fragment) {
        if (fragment is BottomNavigationFragment)
            bottomNavigation.visibility = View.VISIBLE
        else bottomNavigation.visibility = View.GONE
    }
}