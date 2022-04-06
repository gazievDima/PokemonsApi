package com.gaziev.pokemons.ui.screens.favorites.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.pokemons.R
import com.gaziev.pokemons.ui.models.PokemonUI

class FavoritesAdapter(
    private val pokemons: List<PokemonUI>,
    private val lambda: (name: String) -> Unit
) : RecyclerView.Adapter<FavoritesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return FavoritesHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesHolder, position: Int) {
        holder.bind(pokemons[position], lambda)
    }

    override fun getItemCount(): Int = pokemons.size
}