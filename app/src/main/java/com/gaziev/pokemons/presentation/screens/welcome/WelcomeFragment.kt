package com.gaziev.pokemons.presentation.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gaziev.pokemons.App
import com.gaziev.pokemons.databinding.FragmentWelcomeBinding
import com.gaziev.pokemons.presentation.common.BaseFragment
import com.gaziev.pokemons.presentation.common.ToolbarFragment
import com.gaziev.pokemons.presentation.screens.welcome.about.AboutDialogFragment

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(), ToolbarFragment {

    override fun getName(): String = "Pokemonchiki"

    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWelcomeBinding = FragmentWelcomeBinding::inflate
    private val actionToPokemon = WelcomeFragmentDirections.actionWelcomeFragmentToPokemonsFragment()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as App).appComponent.inject(this)

        binding.pokemons.setOnClickListener {
            findNavController().navigate(actionToPokemon) }
        binding.about.setOnClickListener {
           AboutDialogFragment().show(childFragmentManager, null)
        }
    }

}