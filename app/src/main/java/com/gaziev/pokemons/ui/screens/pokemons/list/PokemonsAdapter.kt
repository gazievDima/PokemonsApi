package com.gaziev.pokemons.ui.screens.pokemons.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonApi
import com.gaziev.domain.models.PokemonBD
import com.gaziev.pokemons.R

class PokemonsAdapter(
    private val pokemons: List<PokemonApi>,
    private val lambda: (pokemon: PokemonApi) -> Unit
) : RecyclerView.Adapter<PokemonsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonsHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonsHolder, position: Int) {
        holder.bind(pokemons[position], lambda)
    }

    override fun getItemCount(): Int = pokemons.size

}