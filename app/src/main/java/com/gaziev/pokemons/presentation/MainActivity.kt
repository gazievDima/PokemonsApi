package com.gaziev.pokemons.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.ActivityMainBinding
import com.gaziev.pokemons.presentation.common.BottomNavigationFragment
import com.gaziev.pokemons.presentation.common.ToolbarFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.ToolbarFavoriteIcon
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.ToolbarSearchIcon
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.ToolbarSortIcon


class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val navHostFragment: NavHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment }
    private val navController: NavController by lazy { navHostFragment.navController }
    var imm: InputMethodManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        toolbarListeners()
        initBottomNavigation()
        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?

    }

    private fun initBottomNavigation() {
        binding.bottomNavigation.setupWithNavController(navController)
    }

    private fun toolbarListeners() {
        with(binding) {

            toolbar.setNavigationOnClickListener {
                if (!navController.popBackStack()) finish()
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

        binding.toolbar.menu[0].isVisible = fragment is ToolbarSearchIcon
        binding.toolbar.menu[1].isVisible = fragment is ToolbarSortIcon
        binding.toolbar.menu[2].isVisible = fragment is ToolbarFavoriteIcon
    }

    override fun onBackPressed() {
        if (!navController.popBackStack()) {
            finish()
        }
    }

    fun showKeyboard() {
        imm!!.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )
    }

    fun hideKeyboard() {
        imm!!.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

}