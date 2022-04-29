package com.gaziev.pokemons.presentation.screens.pokemons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.pokemons.App
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.FragmentPokemonsBinding
import com.gaziev.pokemons.presentation.common.MainActivity
import com.gaziev.pokemons.presentation.common.BaseFragment
import com.gaziev.pokemons.presentation.common.BottomNavigationFragment
import com.gaziev.pokemons.presentation.common.ToolbarFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.ToolbarFavoriteIcon
import com.gaziev.pokemons.presentation.screens.pokemons.list.PokemonsAdapter
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class PokemonsFragment : BaseFragment<FragmentPokemonsBinding>(), BottomNavigationFragment,
    ToolbarFragment,
    ToolbarFavoriteIcon {

    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPokemonsBinding =
        FragmentPokemonsBinding::inflate
    private val actionToFavorite = PokemonsFragmentDirections.actionPokemonsFragmentToFavoriteFragment()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as App).daggerAppComponent.inject(this)
        val viewModel = ViewModelProvider(this, viewModelFactory)[PokemonsViewModel::class.java]

            viewModel.pokemons.observe(viewLifecycleOwner) { list ->
                    binding.pokemonsRecycler.layoutManager =
                        LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                    binding.pokemonsRecycler.adapter = PokemonsAdapter(list) { pokemon: PokemonRemoteDetails ->
                        val bundle = Bundle()
                        bundle.putSerializable("info", pokemon)
                        findNavController().navigate(R.id.cardFragment, bundle)
                    }
                binding.splash.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    if (findNavController().currentDestination?.id != R.id.favoriteFragment)
                        findNavController().navigate(actionToFavorite)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

}