package com.gaziev.pokemons.presentation.screens.pokemons.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.ItemPokemonBinding

class PokemonsPagingHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemPokemonBinding.bind(itemView)

    fun bind(
        pokemon: PokemonRemoteDetails,
        clickOpenCard: (pokemon: PokemonRemoteDetails) -> Unit,
        clickFavoriteCard: (pokemon: PokemonRemoteDetails) -> Unit
        ) {

        binding.favorite.setOnClickListener {
            clickFavoriteCard(pokemon)
        }

        binding.cardImage.setOnClickListener {
            clickOpenCard(pokemon)
        }

        binding.nameText.text = pokemon.name
        Glide.with(itemView).load(pokemon.images?.small)
            .centerCrop().placeholder(R.drawable.loading).into(binding.cardImage)

    }
}