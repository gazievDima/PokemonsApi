package com.gaziev.pokemons.presentation.screens.card

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.pokemons.App
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.FragmentCardBinding
import com.gaziev.pokemons.presentation.common.BaseFragment
import com.gaziev.pokemons.presentation.screens.pokemons.PokemonsViewModel
import javax.inject.Inject

class CardFragment : BaseFragment<FragmentCardBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: CardViewModel by viewModels { viewModelFactory }
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCardBinding =
        FragmentCardBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as App).daggerAppComponent.inject(this)

        if (savedInstanceState == null) {
            arguments?.getSerializable("info")?.apply {
                if (this is PokemonLocalDetails) {
                    viewModel.setLocalPokemon(this)
                    viewModel.flagLocalPokemon = true
                }
                if (this is PokemonRemoteDetails) {
                    viewModel.setRemotePokemon(this)
                    viewModel.flagLocalPokemon = false
                }

            }
        }
        subscribe()

        binding.close.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun subscribe() {
        if(viewModel.flagLocalPokemon) subscribePokemonLocal()
            else subscribePokemonRemote()
    }

    @SuppressLint("SetTextI18n")
    private fun subscribePokemonRemote() {
        viewModel.pokemonRemote.observe(viewLifecycleOwner) {
            with(binding) {
                tvId.text = "Id: ${it.id ?: "..."}"
                tvName.text = "Name: ${it.name ?: "..."}"
                tvSupertype.text = "Supertype: ${it.supertype ?: "..."}"
                tvSubtypes.text = "Subtypes: ${it.supertype ?: "..."}"
                tvHp.text = "Hp: ${it.hp ?: "..."}"
                tvTypes.text = "Types: ${it.types ?: "..."}"
                tvEvolvesTo.text = "Evolves: ${it.evolvesTo ?: "..."}"
                tvRules.text = "Rules: ${it.rules ?: "..."}"
                tvArtist.text = "Artist: ${it.artist ?: "..."}"
                tvRarity.text = "Rarity: ${it.rarity ?: "..."}"

                Glide
                    .with(this@CardFragment)
                    .load(it.images?.small)
                    .centerCrop()
                    .placeholder(R.drawable.loading)
                    .into(cardImage)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun subscribePokemonLocal() {
        viewModel.pokemonLocal.observe(viewLifecycleOwner) {
            with(binding) {
                tvId.text = "Id: ${it.id ?: "..."}"
                tvName.text = "Name: ${it.name ?: "..."}"
                tvSupertype.text = "Supertype: ${it.supertype ?: "..."}"
                tvSubtypes.text = "Subtypes: ${it.supertype ?: "..."}"
                tvHp.text = "Hp: ${it.hp ?: "..."}"
                tvArtist.text = "Artist: ${it.artist ?: "..."}"
                tvRarity.text = "Rarity: ${it.rarity ?: "..."}"
            }
        }
    }
}

