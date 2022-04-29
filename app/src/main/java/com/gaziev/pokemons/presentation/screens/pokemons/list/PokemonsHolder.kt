package com.gaziev.pokemons.presentation.screens.pokemons.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.ItemPokemonBinding

class PokemonsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemPokemonBinding.bind(itemView)

    fun bind(pokemon: PokemonRemoteDetails, lambda: (pokemon: PokemonRemoteDetails) -> Unit) {
        Glide
            .with(itemView)
            .load(pokemon.images?.large)
            .centerCrop()
            .placeholder(R.drawable.loading)
            .into(binding.cardImage)

        binding.cardImage.setOnClickListener {
            lambda(pokemon)
        }
        binding.nameText.text = pokemon.name

    }

}