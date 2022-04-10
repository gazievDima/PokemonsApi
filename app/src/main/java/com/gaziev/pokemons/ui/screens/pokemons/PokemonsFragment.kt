package com.gaziev.pokemons.ui.screens.pokemons

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.Pokemon
import com.gaziev.pokemons.databinding.FragmentPokemonsBinding
import com.gaziev.pokemons.ui.common.fragments.BaseFragment
import com.gaziev.pokemons.ui.common.fragments.BottomNavigationFragment
import com.gaziev.pokemons.ui.common.ViewModelFactory
import com.gaziev.pokemons.ui.common.fragments.ToolbarFragment
import com.gaziev.pokemons.ui.screens.pokemons.list.PokemonsAdapter

class PokemonsFragment : BaseFragment<FragmentPokemonsBinding>(), BottomNavigationFragment, ToolbarFragment {

    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPokemonsBinding =
        FragmentPokemonsBinding::inflate
    private val viewModel: PokemonsViewModel by viewModels { ViewModelFactory() }
    private val actionToCardPokemon =
        PokemonsFragmentDirections.actionPokemonsFragmentToCardFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemons.observe(viewLifecycleOwner) { list: List<Pokemon>? ->
            list?.let {
                binding.pokemonsRecycler.layoutManager =
                    GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
                binding.pokemonsRecycler.adapter = PokemonsAdapter(list) { name: String ->
                    findNavController().navigate(actionToCardPokemon)
                    Log.i("TAGS", "Pokemon name: $name")
                }
            }
        }
    }

}