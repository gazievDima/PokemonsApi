package com.gaziev.pokemons.presentation

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.ActivityMainBinding
import com.gaziev.pokemons.presentation.common.MainBottomNavigation
import com.gaziev.pokemons.presentation.common.MainToolbar
import com.gaziev.pokemons.presentation.common.SoftKeyboardManager

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val navController: NavController by lazy { (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController }
    val mainToolbar: MainToolbar by lazy { MainToolbar(binding.toolbar, this) }
    val mainBottomNavigation: MainBottomNavigation by lazy { MainBottomNavigation(binding.bottomNavigation, navController) }
    val keyboardManager: SoftKeyboardManager by lazy { SoftKeyboardManager(getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager, binding.root) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
    }

    override fun onBackPressed() { if (!navController.popBackStack()) finish() }
}