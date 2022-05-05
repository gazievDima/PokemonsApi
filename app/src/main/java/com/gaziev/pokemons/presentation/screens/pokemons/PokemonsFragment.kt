package com.gaziev.pokemons.presentation.screens.pokemons

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.pokemons.App
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.FragmentPokemonsBinding
import com.gaziev.pokemons.presentation.common.BaseFragment
import com.gaziev.pokemons.presentation.common.BottomNavigationFragment
import com.gaziev.pokemons.presentation.common.ToolbarFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.ToolbarFavoriteIcon
import com.gaziev.pokemons.presentation.screens.pokemons.list.PokemonsPagingAdapter
import com.gaziev.pokemons.presentation.screens.pokemons.list.PokemonsComparator
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonsFragment : BaseFragment<FragmentPokemonsBinding>(),
    BottomNavigationFragment,
    ToolbarFragment,
    ToolbarFavoriteIcon {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: PokemonsViewModel by viewModels { viewModelFactory }
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPokemonsBinding =
        FragmentPokemonsBinding::inflate
    private val actionToFavorite =
        PokemonsFragmentDirections.actionPokemonsFragmentToFavoriteFragment()
    private var pagingAdapter: PokemonsPagingAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as App).appComponent.inject(this)
        initRecycler()
        pagingLoadListener()
        subscribe()
    }

    override fun onResume() {
        super.onResume()
        PokemonsToolbarListener(mainToolbar.toolbar).setup {
            if (findNavController().currentDestination?.id != R.id.favoriteFragment)
                findNavController().navigate(actionToFavorite)
        }
    }

    private fun initRecycler() {
        pagingAdapter = PokemonsPagingAdapter(PokemonsComparator) { pokemon: PokemonRemoteDetails ->
            val bundle = Bundle()
            bundle.putSerializable("info", pokemon)
            findNavController().navigate(R.id.cardFragment, bundle)
        }

        binding.pokemonsRecycler.layoutManager =
            GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        binding.pokemonsRecycler.adapter = pagingAdapter
    }


    private fun pagingLoadListener() {
        pagingAdapter?.addLoadStateListener { state ->
            if (state.refresh != LoadState.Loading) {
                binding.screenError.splash.visibility = View.GONE
                binding.screenLoading.splash.visibility = View.GONE
            }

            if(state.refresh is LoadState.Error) {
                binding.screenError.splash.visibility = View.VISIBLE
                binding.screenLoading.splash.visibility = View.GONE
            }
        }
    }

    private fun subscribe() {
        lifecycleScope.launchWhenStarted {
            launch {
                viewModel.pokemons()
                    .collectLatest { pagingData ->
                        pagingAdapter?.submitData(pagingData)
                    }
            }
        }

    }
}


