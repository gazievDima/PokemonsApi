package com.gaziev.pokemons.presentation.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.gaziev.pokemons.presentation.MainActivity
import dagger.android.support.DaggerFragment


abstract class BaseFragment<T : ViewBinding> : Fragment() {
    abstract val inflate: (LayoutInflater, ViewGroup?, Boolean) -> T
    private var _binding: T? = null
    val binding: T get() = _binding!!
    private val mainBottomNavigation: MainBottomNavigation by lazy { (requireActivity() as MainActivity).mainBottomNavigation }
    val mainToolbar: MainToolbar by lazy { (requireActivity() as MainActivity).mainToolbar }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(layoutInflater, container, false)

        (activity as MainActivity).binding.appBar.setExpanded(true, false)
        mainBottomNavigation.setup(this)
        mainToolbar.setup(this)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}