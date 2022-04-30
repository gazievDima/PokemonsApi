package com.gaziev.pokemons.presentation.screens.pokemons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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
import com.gaziev.pokemons.presentation.screens.pokemons.list.PokemonsAdapter
import javax.inject.Inject

class PokemonsFragment : BaseFragment<FragmentPokemonsBinding>(),
    BottomNavigationFragment,
    ToolbarFragment,
    ToolbarFavoriteIcon {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: PokemonsViewModel by viewModels { viewModelFactory }
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPokemonsBinding = FragmentPokemonsBinding::inflate
    private val actionToFavorite = PokemonsFragmentDirections.actionPokemonsFragmentToFavoriteFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as App).daggerAppComponent.inject(this)
        subscribe()
    }

    override fun onResume() {
        super.onResume()
        PokemonsToolbarListener(mainToolbar.toolbar).setup {
            if (findNavController().currentDestination?.id != R.id.favoriteFragment)
                findNavController().navigate(actionToFavorite)
        }
    }

    private fun subscribe() {
        viewModel.pokemons.observe(viewLifecycleOwner) { list ->
            binding.pokemonsRecycler.layoutManager =
                GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
            binding.pokemonsRecycler.adapter =
                PokemonsAdapter(list) { pokemon: PokemonRemoteDetails ->
                    val bundle = Bundle()
                    bundle.putSerializable("info", pokemon)
                    findNavController().navigate(R.id.cardFragment, bundle)
                }
            binding.splash.visibility = View.GONE
        }
    }
}

