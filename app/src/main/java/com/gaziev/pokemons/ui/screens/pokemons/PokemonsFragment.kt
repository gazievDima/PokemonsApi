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
<<<<<<< HEAD
import com.gaziev.domain.models.PokemonApi
=======
import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.pokemons.R
>>>>>>> UI
import com.gaziev.pokemons.databinding.FragmentPokemonsBinding
import com.gaziev.pokemons.ui.MainActivity
import com.gaziev.pokemons.ui.common.fragments.BaseFragment
import com.gaziev.pokemons.ui.common.fragments.IBottomNavigationFragment
import com.gaziev.pokemons.ui.common.ViewModelFactory
import com.gaziev.pokemons.ui.common.fragments.IToolbarFragment
import com.gaziev.pokemons.ui.common.fragments.toolbar.IToolbarFavoriteIcon
import com.gaziev.pokemons.ui.screens.pokemons.list.PokemonsAdapter
import com.gaziev.pokemons.ui.screens.welcome.WelcomeFragmentDirections

class PokemonsFragment : BaseFragment<FragmentPokemonsBinding>(), IBottomNavigationFragment, IToolbarFragment, IToolbarFavoriteIcon {

    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPokemonsBinding =
        FragmentPokemonsBinding::inflate
    private val viewModel: PokemonsViewModel by viewModels { ViewModelFactory() }
    private val actionToCardPokemon =
        PokemonsFragmentDirections.actionPokemonsFragmentToCardFragment()
    private val actionToFavorite = PokemonsFragmentDirections.actionPokemonsFragmentToFavoriteFragment()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemons.observe(viewLifecycleOwner) { list: List<PokemonApi>? ->
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