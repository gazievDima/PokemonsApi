package com.gaziev.pokemons.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.ActivityMainBinding
import com.gaziev.pokemons.ui.common.fragments.BottomNavigationFragment
import com.gaziev.pokemons.ui.common.fragments.ToolbarFragment


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val navHostFragment: NavHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment }
    private val navController: NavController by lazy { navHostFragment.navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        if (savedInstanceState == null) {
            toolbarListeners()
            initBottomNavigation()
        }
    }

    private fun initBottomNavigation() {
        binding.bottomNavigation.setupWithNavController(navController)
    }

    private fun toolbarListeners() {
        with(binding) {

            toolbar.setNavigationOnClickListener {
                if (!navController.popBackStack()) finish()
            }

            toolbar.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.favorite -> {
                        if (navController.currentDestination?.id != R.id.favoriteFragment)
                            navController.navigate(R.id.favoriteFragment)
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
        }
    }

    fun bottomNavigationController(fragment: Fragment) {
        if (fragment is BottomNavigationFragment)
            binding.bottomNavigation.visibility = View.VISIBLE
        else binding.bottomNavigation.visibility = View.GONE
    }

    fun toolbarController(fragment: Fragment) {
        if (fragment is ToolbarFragment)
            binding.toolbar.visibility = View.VISIBLE
        else binding.toolbar.visibility = View.GONE
    }

}