package com.gaziev.pokemons.ui.screens.favorites.pager.latest.list

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonBD
import com.gaziev.pokemons.R

class LatestHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pokemon: PokemonBD, lambda: (pokemon: PokemonBD) -> Unit) {
        val info =
                    "id: ${pokemon.id}" + "\n" +
                    "name: ${pokemon.name}" + "\n" +
                    "supertype: ${pokemon.supertype}" + "\n" +
                    "hp: ${pokemon.hp}" + "\n" +
                    "number: ${pokemon.number}" + "\n" +
                    "artist: ${pokemon.artist}" + "\n"

        itemView.findViewById<LinearLayoutCompat>(R.id.card)?.apply { setOnClickListener { lambda(pokemon) } }
        itemView.findViewById<TextView>(R.id.nameText)?.apply {
            text = info
        }
    }

}