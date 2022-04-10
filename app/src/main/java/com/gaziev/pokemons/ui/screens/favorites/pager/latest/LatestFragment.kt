package com.gaziev.pokemons.ui.screens.favorites.pager.latest

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
import com.gaziev.pokemons.databinding.PagerFavoritesLatestBinding
import com.gaziev.pokemons.ui.common.ViewModelFactory
import com.gaziev.pokemons.ui.screens.favorites.FavoritesFragmentDirections
import com.gaziev.pokemons.ui.screens.favorites.pager.latest.list.LatestAdapter
import com.gaziev.pokemons.ui.screens.favorites.pager.common.PagerBaseFragment

class LatestFragment : PagerBaseFragment<PagerFavoritesLatestBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> PagerFavoritesLatestBinding =
        PagerFavoritesLatestBinding::inflate

    private val viewModel: LatestViewModel by viewModels { ViewModelFactory() }
    private val actionToCardPokemon =
        FavoritesFragmentDirections.actionFavoriteFragmentToCardFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemons.observe(viewLifecycleOwner) { list: List<PokemonApiDao>? ->
            list?.let {
                binding.favoritesRecycler.layoutManager =
                    GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
                binding.favoritesRecycler.adapter = LatestAdapter(list) { name: String ->
                    findNavController().navigate(actionToCardPokemon)
                    Log.i("TAGS", "Favorite pokemon name: $name")
                }

            }

        }
    }
}
