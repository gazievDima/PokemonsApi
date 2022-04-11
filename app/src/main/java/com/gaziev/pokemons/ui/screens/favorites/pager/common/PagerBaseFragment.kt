package com.gaziev.pokemons.ui.screens.favorites.pager.common

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.gaziev.pokemons.ui.MainActivity

abstract class PagerBaseFragment<T : ViewBinding> : Fragment() {
    abstract val inflate: (LayoutInflater, ViewGroup?, Boolean) -> T
    private var _binding: T? = null
    val binding: T get() = _binding!!

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