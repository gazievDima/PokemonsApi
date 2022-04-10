package com.gaziev.pokemons.ui.screens.favorites.pager.health.list

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.pokemons.R
import com.gaziev.pokemons.core.models.common.Pokemon

class HealthHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pokemon: Pokemon, lambda: (name: String) -> Unit) {
        val health = "Health " + (Math.random() * 99).toInt() + 1

        itemView.findViewById<LinearLayoutCompat>(R.id.card)?.apply { setOnClickListener { lambda(pokemon.name) } }
        itemView.findViewById<TextView>(R.id.nameText)?.apply {
            text = health
        }
    }

}