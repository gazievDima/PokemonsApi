package com.gaziev.pokemons.ui.screens.pokemons

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.pokemons.databinding.FragmentPokemonsBinding
import com.gaziev.pokemons.ui.common.BaseFragment
import com.gaziev.pokemons.ui.common.ViewModelFactory
import com.gaziev.pokemons.ui.models.PokemonUI
import com.gaziev.pokemons.ui.screens.pokemons.list.PokemonsAdapter

class PokemonsFragment : BaseFragment<FragmentPokemonsBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPokemonsBinding = FragmentPokemonsBinding::inflate
    private val viewModel: PokemonsViewModel by viewModels { ViewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemons.observe(viewLifecycleOwner) { list: List<PokemonUI>? ->
            list?.let{
                binding.pokemonsRecycler.layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
                binding.pokemonsRecycler.adapter = PokemonsAdapter(list) { name: String? ->
                    name?.let {
                    Log.i("TAGS", "Pokemon name: $name")
                }
                }
            }
        }
    }

}