package com.gaziev.pokemons.ui.screens.favorites.pager.names.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.pokemons.R
import com.gaziev.pokemons.ui.models.PokemonUI

class NamesAdapter(
    private val pokemons: List<PokemonUI>,
    private val lambda: (name: String) -> Unit
) : RecyclerView.Adapter<NamesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return NamesHolder(view)
    }

    override fun onBindViewHolder(holder: NamesHolder, position: Int) {
        holder.bind(pokemons[position], lambda)
    }

    override fun getItemCount(): Int = pokemons.size

}