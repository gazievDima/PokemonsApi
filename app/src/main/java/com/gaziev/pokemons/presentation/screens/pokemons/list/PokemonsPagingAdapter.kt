package com.gaziev.pokemons.presentation.screens.pokemons.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.pokemons.R

class PokemonsPagingAdapter(
    private val diffCallback: DiffUtil.ItemCallback<PokemonRemoteDetails>,
    private val clickOpenCard: (pokemon: PokemonRemoteDetails) -> Unit,
    private val clickFavoriteCard: (pokemon: PokemonRemoteDetails) -> Unit,
    ) : PagingDataAdapter<PokemonRemoteDetails, PokemonsPagingHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsPagingHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonsPagingHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonsPagingHolder, position: Int) {
        holder.bind(getItem(position)!!, clickOpenCard, clickFavoriteCard)
    }
}

