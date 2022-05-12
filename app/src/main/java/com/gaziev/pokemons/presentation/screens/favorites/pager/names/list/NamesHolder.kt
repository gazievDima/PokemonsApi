package com.gaziev.pokemons.presentation.screens.favorites.pager.names.list

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.ItemFavoriteBinding

class NamesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemFavoriteBinding.bind(itemView)

    fun bind(pokemon: PokemonLocalDetails, lambda: (pokemon: PokemonLocalDetails) -> Unit) {
        binding.pokemonCard.setCardImage(binding.pokemonCard, pokemon.images?.small)
        binding.pokemonCard.setFields(pokemon, visibilityNumber = View.GONE, null)

        binding.pokemonCard.setOnClickListener {
            lambda(pokemon)
        }
    }

}