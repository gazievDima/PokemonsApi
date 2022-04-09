package com.gaziev.pokemons.ui.screens.favorites.pager.strong.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.pokemons.R
import com.gaziev.pokemons.ui.models.PokemonUI

class StrongHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pokemon: PokemonUI, lambda: (name: String) -> Unit) {
        val strong = "Strong " + (Math.random() * 9).toInt() + 1

        itemView.findViewById<LinearLayoutCompat>(R.id.card)?.apply { setOnClickListener { lambda(pokemon.name) } }
        itemView.findViewById<TextView>(R.id.nameText)?.apply {
            text = strong
        }
    }

}