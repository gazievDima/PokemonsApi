package com.gaziev.pokemons.presentation.screens.pokemons.list

import androidx.recyclerview.widget.DiffUtil
import com.gaziev.domain.models.PokemonRemoteDetails

object PokemonsComparator : DiffUtil.ItemCallback<PokemonRemoteDetails>() {

    override fun areItemsTheSame(oldItem: PokemonRemoteDetails, newItem: PokemonRemoteDetails): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PokemonRemoteDetails, newItem: PokemonRemoteDetails): Boolean {
        return oldItem.id == newItem.id
    }
}