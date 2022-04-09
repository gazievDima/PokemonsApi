package com.gaziev.pokemons.ui.screens.favorites.pager.az.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.pokemons.R
import com.gaziev.pokemons.ui.models.PokemonUI
import com.gaziev.pokemons.ui.screens.favorites.pager.strong.list.StrongHolder

class AZAdapter(
    private val pokemons: List<PokemonUI>,
    private val lambda: (name: String) -> Unit
) : RecyclerView.Adapter<AZHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AZHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return AZHolder(view)
    }

    override fun onBindViewHolder(holder: AZHolder, position: Int) {
        holder.bind(pokemons[position], lambda)
    }

    override fun getItemCount(): Int = pokemons.size

}