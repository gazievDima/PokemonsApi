package com.gaziev.pokemons.ui.screens.favorites.pager.strong.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.pokemons.R
import com.gaziev.pokemons.ui.models.PokemonUI

class StrongAdapter(
    private val pokemons: List<PokemonUI>,
    private val lambda: (name: String) -> Unit
) : RecyclerView.Adapter<StrongHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StrongHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return StrongHolder(view)
    }

    override fun onBindViewHolder(holder: StrongHolder, position: Int) {
        holder.bind(pokemons[position], lambda)
    }

    override fun getItemCount(): Int = pokemons.size

}