package com.gaziev.pokemons.ui.screens.pokemons.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.pokemons.R
import com.gaziev.pokemons.ui.models.PokemonUI

class PokemonsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pokemon: PokemonUI, lambda: (name: String) -> Unit) {
        itemView.findViewById<ImageView>(R.id.cardImage)?.apply { setOnClickListener { lambda(pokemon.name) } }
        itemView.findViewById<TextView>(R.id.nameText)?.apply { text = pokemon.name }
    }

}