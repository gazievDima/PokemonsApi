package com.gaziev.pokemons.presentation.screens.favorites.pager.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.gaziev.pokemons.presentation.MainActivity
import com.gaziev.pokemons.presentation.common.MainBottomNavigation
import com.gaziev.pokemons.presentation.common.MainToolbar

abstract class PagerBaseFragment<T : ViewBinding> : Fragment() {
    abstract val inflate: (LayoutInflater, ViewGroup?, Boolean) -> T
    private var _binding: T? = null
    val binding: T get() = _binding!!
    val mainToolbar: MainToolbar by lazy { (requireActivity() as MainActivity).mainToolbar }
    val mainActivity: MainActivity by lazy { requireActivity() as MainActivity }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(layoutInflater, container, false)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}