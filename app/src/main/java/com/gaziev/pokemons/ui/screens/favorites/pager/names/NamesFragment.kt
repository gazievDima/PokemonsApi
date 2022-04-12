package com.gaziev.pokemons.ui.screens.favorites.pager.names

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonBD
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.PagerFavoritesNamesBinding
import com.gaziev.pokemons.ui.MainActivity
import com.gaziev.pokemons.ui.common.ViewModelFactory
import com.gaziev.pokemons.ui.screens.favorites.FavoritesFragmentDirections
import com.gaziev.pokemons.ui.screens.favorites.pager.common.PagerBaseFragment
import com.gaziev.pokemons.ui.screens.favorites.pager.common.SearchToolbar
import com.gaziev.pokemons.ui.screens.favorites.pager.names.list.NamesAdapter

class NamesFragment : PagerBaseFragment<PagerFavoritesNamesBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> PagerFavoritesNamesBinding =
        PagerFavoritesNamesBinding::inflate
    private val viewModel: NamesViewModel by viewModels { ViewModelFactory() }
    private val actionToCardPokemon =
        FavoritesFragmentDirections.actionFavoriteFragmentToCardFragment()
    private var searchToolbar: SearchToolbar? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemons.observe(viewLifecycleOwner) { list: List<PokemonBD>? ->
            list?.let {
                binding.favoritesRecycler.layoutManager =
                    GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
                binding.favoritesRecycler.adapter = NamesAdapter(list) { name: String ->
                    findNavController().navigate(actionToCardPokemon)
                }
            }
        }
        searchToolbar = SearchToolbar(
            (activity as MainActivity).binding.inputClose,
            (activity as MainActivity).binding.inputSearch,
            (activity as MainActivity)
        )
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    searchToolbar?.modeOn()
                    true
                }
                R.id.sort -> {
                    viewModel.sortItems()
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

    override fun onPause() {
        super.onPause()
        searchToolbar?.modeOff()
    }

}

