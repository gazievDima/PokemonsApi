package com.gaziev.pokemons.presentation.screens.favorites.pager.health.list

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.ItemFavoriteBinding

class HealthHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemFavoriteBinding.bind(itemView)

    fun bind(pokemon: PokemonLocalDetails, lambda: (pokemon: PokemonLocalDetails) -> Unit) {
        val info =
         //   "primary_key: ${pokemon.primary_key}" + "\n" +
                    "id: ${pokemon.id}" + "\n" +
                    "name: ${pokemon.name}" + "\n"

        binding.card.setOnClickListener {
            lambda(pokemon)
        }
        binding.nameText.text = info
    }

}