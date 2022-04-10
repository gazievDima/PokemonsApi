package com.gaziev.pokemons.ui.screens.favorites.pager.names.list

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.pokemons.R

class NamesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pokemon: PokemonApiDao, lambda: (name: String) -> Unit) {
        val name = "Name " + pokemon.name

        itemView.findViewById<LinearLayoutCompat>(R.id.card)?.apply { setOnClickListener { lambda(pokemon.name) } }
        itemView.findViewById<TextView>(R.id.nameText)?.apply {
            text = name
        }
    }

}