package com.gaziev.pokemons.ui.screens.favorites.pager.health

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
<<<<<<< HEAD
import com.gaziev.domain.models.PokemonBD
=======
import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.domain.models.PokemonBDDao
import com.gaziev.pokemons.R
>>>>>>> UI
import com.gaziev.pokemons.databinding.PagerFavoritesHealthBinding
import com.gaziev.pokemons.ui.MainActivity
import com.gaziev.pokemons.ui.common.ViewModelFactory
import com.gaziev.pokemons.ui.common.fragments.toolbar.IToolbarSearchIcon
import com.gaziev.pokemons.ui.common.fragments.toolbar.IToolbarSortIcon
import com.gaziev.pokemons.ui.screens.favorites.FavoritesFragmentDirections
import com.gaziev.pokemons.ui.screens.favorites.pager.common.PagerBaseFragment
import com.gaziev.pokemons.ui.screens.favorites.pager.common.SearchToolbar
import com.gaziev.pokemons.ui.screens.favorites.pager.health.list.HealthAdapter

class HealthFragment : PagerBaseFragment<PagerFavoritesHealthBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> PagerFavoritesHealthBinding =
        PagerFavoritesHealthBinding::inflate
    private val viewModel: HealthViewModel by viewModels { ViewModelFactory() }
    private val actionToCardPokemon =
        FavoritesFragmentDirections.actionFavoriteFragmentToCardFragment()
    private var searchToolbar: SearchToolbar? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemons.observe(viewLifecycleOwner) { list: List<PokemonBD>? ->
            list?.let {
                binding.favoritesRecycler.layoutManager =
                    GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
                binding.favoritesRecycler.adapter = HealthAdapter(list) { name: String ->
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