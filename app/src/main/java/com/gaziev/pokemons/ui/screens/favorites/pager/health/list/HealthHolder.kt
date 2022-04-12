package com.gaziev.pokemons.ui.screens.favorites.pager.health.list

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonBD
import com.gaziev.pokemons.R

class HealthHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pokemon: PokemonBD, lambda: (name: String) -> Unit) {
        val info =
            "primary_key: ${pokemon.primary_key}" + "\n" +
                    "name: ${pokemon.name}" + "\n" +
                    "hp: ${pokemon.hp}"

        itemView.findViewById<LinearLayoutCompat>(R.id.card)
            ?.apply { setOnClickListener { lambda(pokemon.name) } }
        itemView.findViewById<TextView>(R.id.nameText)?.apply {
            text = info
        }
    }

}