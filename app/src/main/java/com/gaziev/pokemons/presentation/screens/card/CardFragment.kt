package com.gaziev.pokemons.presentation.screens.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.FragmentCardBinding
import com.gaziev.pokemons.presentation.common.BaseFragment

class CardFragment : BaseFragment<FragmentCardBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCardBinding =
        FragmentCardBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemon = arguments?.getSerializable("info")
        var info = "Not data"
        if (pokemon != null) {
            if (pokemon is PokemonLocalDetails) {
                info = """
            id: ${pokemon.id}
            name: ${pokemon.name}
            supertype: ${pokemon.supertype}
            hp: ${pokemon.hp}
            number: ${pokemon.number}
            artist: ${pokemon.artist}
            rarity: ${pokemon.rarity}
            flavorText: ${pokemon.flavorText}
        """.trimIndent()
            }
            if (pokemon is PokemonRemoteDetails) {
                info = """
            id: ${pokemon.id}
            name: ${pokemon.name}
            supertype: ${pokemon.supertype}
            hp: ${pokemon.hp}
            number: ${pokemon.number}
            artist: ${pokemon.artist}
            rarity: ${pokemon.rarity}
            flavorText: ${pokemon.flavorText}
        """.trimIndent()

                Glide
                    .with(this)
                    .load(pokemon.images?.large)
                    .centerCrop()
                    .placeholder(R.drawable.loading)
                    .into(binding.cardImage)
            }
        }
        binding.info.text = info

        binding.close.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}

