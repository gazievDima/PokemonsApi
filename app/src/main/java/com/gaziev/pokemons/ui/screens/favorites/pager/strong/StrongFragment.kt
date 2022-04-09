package com.gaziev.pokemons.ui.screens.favorites.pager.strong

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.pokemons.databinding.PagerFavoritesStrongBinding
import com.gaziev.pokemons.ui.common.ViewModelFactory
import com.gaziev.pokemons.ui.models.PokemonUI
import com.gaziev.pokemons.ui.screens.favorites.FavoritesFragmentDirections
import com.gaziev.pokemons.ui.screens.favorites.pager.common.PagerBaseFragment
import com.gaziev.pokemons.ui.screens.favorites.pager.strong.list.StrongAdapter

class StrongFragment : PagerBaseFragment<PagerFavoritesStrongBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> PagerFavoritesStrongBinding = PagerFavoritesStrongBinding::inflate
    private val viewModel: StrongViewModel by viewModels { ViewModelFactory() }
    private val actionToCardPokemon =
        FavoritesFragmentDirections.actionFavoriteFragmentToCardFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemons.observe(viewLifecycleOwner) { list: List<PokemonUI>? ->
            list?.let {
                binding.favoritesRecycler.layoutManager =
                    GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
                binding.favoritesRecycler.adapter = StrongAdapter(list) { name: String ->
                    findNavController().navigate(actionToCardPokemon)
                    Log.i("TAGS", "Favorite pokemon name: $name")
                }
            }
        }
    }
}