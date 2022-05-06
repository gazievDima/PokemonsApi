package com.gaziev.pokemons.presentation.screens.favorites.pager.names

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.pokemons.App
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.PagerFavoritesNamesBinding
import com.gaziev.pokemons.presentation.MainActivity
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.PagerBaseFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.PagerToolbarListener
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.SearchTextWatcher
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.SearchToolbar
import com.gaziev.pokemons.presentation.screens.favorites.pager.health.list.HealthAdapter
import com.gaziev.pokemons.presentation.screens.favorites.pager.names.list.NamesAdapter
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class NamesFragment : PagerBaseFragment<PagerFavoritesNamesBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: NamesViewModel by viewModels { viewModelFactory }
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> PagerFavoritesNamesBinding =
        PagerFavoritesNamesBinding::inflate
    private val searchToolbar: SearchToolbar by lazy { SearchToolbar(mainActivity) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as App).appComponent.inject(this)

        viewModel.getPokemons()
        subscribe()

        SearchTextWatcher(mainActivity, lifecycleScope).setup {
            viewModel.search(it)
        }
    }

    override fun onResume() {
        super.onResume()
        PagerToolbarListener(mainToolbar.toolbar).setup({
            searchToolbar.modeOn()
        }, {
            viewModel.sortItems()
        })
    }

    override fun onPause() {
        super.onPause()
        searchToolbar.modeOff()
        viewModel.endSearch()
    }

    private fun subscribe() {
        viewModel.pokemons.observe(viewLifecycleOwner) { list ->
            binding.favoritesRecycler.layoutManager =
                GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
            binding.favoritesRecycler.adapter =
                NamesAdapter(list) { pokemon: PokemonLocalDetails ->
                    val bundle = Bundle()
                    bundle.putSerializable("info", pokemon)
                    findNavController().navigate(R.id.cardFragment, bundle)
                }
        }
    }

}

