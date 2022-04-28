package com.gaziev.pokemons.presentation.screens.pokemons.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.pokemons.R

class PokemonsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pokemon: PokemonRemoteDetails, lambda: (pokemon: PokemonRemoteDetails) -> Unit) {
        itemView.findViewById<ImageView>(R.id.cardImage)?.apply { setOnClickListener { lambda(pokemon) } }
        itemView.findViewById<TextView>(R.id.nameText)?.apply { text = pokemon.name }
    }

}