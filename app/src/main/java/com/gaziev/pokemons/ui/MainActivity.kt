package com.gaziev.pokemons.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.ActivityMainBinding
import com.gaziev.pokemons.ui.common.fragments.BottomNavigationFragment
import com.gaziev.pokemons.ui.common.fragments.ToolbarFragment

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val navController: NavController by lazy { (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            if (!navController.popBackStack()) finish()
        }

        if(savedInstanceState == null) {
            binding.bottomNavigation.setupWithNavController(navController)
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