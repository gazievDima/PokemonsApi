package com.gaziev.pokemons.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gaziev.pokemons.databinding.FragmentWelcomeBinding
import com.gaziev.pokemons.ui.common.fragments.BaseFragment

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWelcomeBinding = FragmentWelcomeBinding::inflate
    private val actionToPokemon = WelcomeFragmentDirections.actionWelcomeFragmentToPokemonsFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pokemons.setOnClickListener { findNavController().navigate(actionToPokemon) }
        binding.exit.setOnClickListener { activity?.finish() }
    }
}