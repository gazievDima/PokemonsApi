package com.gaziev.pokemons.ui.screens.favorites.pager.latest.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonBD
import com.gaziev.pokemons.R

class LatestAdapter(
    private val pokemons: List<PokemonBD>,
    private val lambda: (name: String) -> Unit
) : RecyclerView.Adapter<LatestHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return LatestHolder(view)
    }

    override fun onBindViewHolder(holder: LatestHolder, position: Int) {
        holder.bind(pokemons[position], lambda)
    }

    override fun getItemCount(): Int = pokemons.size

}