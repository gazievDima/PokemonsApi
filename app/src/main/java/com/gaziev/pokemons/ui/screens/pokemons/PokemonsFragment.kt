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
import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.pokemons.databinding.FragmentPokemonsBinding
import com.gaziev.pokemons.ui.common.fragments.BaseFragment
import com.gaziev.pokemons.ui.common.fragments.IBottomNavigationFragment
import com.gaziev.pokemons.ui.common.ViewModelFactory
import com.gaziev.pokemons.ui.common.fragments.IToolbarFragment
import com.gaziev.pokemons.ui.common.fragments.toolbar.IToolbarFavoriteIcon
import com.gaziev.pokemons.ui.screens.pokemons.list.PokemonsAdapter

class PokemonsFragment : BaseFragment<FragmentPokemonsBinding>(), IBottomNavigationFragment, IToolbarFragment, IToolbarFavoriteIcon {

    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPokemonsBinding =
        FragmentPokemonsBinding::inflate
    private val viewModel: PokemonsViewModel by viewModels { ViewModelFactory() }
    private val actionToCardPokemon =
        PokemonsFragmentDirections.actionPokemonsFragmentToCardFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemons.observe(viewLifecycleOwner) { list: List<PokemonApiDao>? ->
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