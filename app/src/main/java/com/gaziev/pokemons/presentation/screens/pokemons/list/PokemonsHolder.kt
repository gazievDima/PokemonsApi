package com.gaziev.pokemons.presentation.screens.pokemons.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonRemote
import com.gaziev.pokemons.R

class PokemonsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pokemon: PokemonRemote, lambda: (pokemon: PokemonRemote) -> Unit) {
        itemView.findViewById<ImageView>(R.id.cardImage)?.apply { setOnClickListener { lambda(pokemon) } }
        itemView.findViewById<TextView>(R.id.nameText)?.apply { text = pokemon.name }
    }

}