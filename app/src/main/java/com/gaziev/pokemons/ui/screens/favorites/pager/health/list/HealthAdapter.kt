package com.gaziev.pokemons.ui.screens.favorites.pager.health.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.pokemons.R
import com.gaziev.pokemons.ui.models.PokemonUI
import com.gaziev.pokemons.ui.screens.favorites.pager.strong.list.StrongHolder

class HealthAdapter(
    private val pokemons: List<PokemonUI>,
    private val lambda: (name: String) -> Unit
) : RecyclerView.Adapter<HealthHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return HealthHolder(view)
    }

    override fun onBindViewHolder(holder: HealthHolder, position: Int) {
        holder.bind(pokemons[position], lambda)
    }

    override fun getItemCount(): Int = pokemons.size

}