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
        binding.tvNumber.visibility = View.GONE
        binding.tvId.text = "id: ${pokemon.id}"
        binding.tvName.text = "name: ${pokemon.name}"
        binding.tvHp.text = "hp: ${pokemon.hp}"

        Glide.with(itemView).load(pokemon.images?.small).fitCenter()
            .placeholder(R.drawable.loading).into(binding.cardImage)

        binding.card.setOnClickListener {
            lambda(pokemon)
        }
    }

}