package com.gaziev.pokemons.ui.screens.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.pokemons.ui.models.PokemonUI

class FavoritesViewModel : ViewModel() {
    private var _pokemons: MutableLiveData<List<PokemonUI>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<PokemonUI>> = _pokemons

    init {
        _pokemons.value = getPokemonsList()
    }

    private fun getPokemonsList(): MutableList<PokemonUI> {
        val list: MutableList<PokemonUI> = mutableListOf()
        for(i in 1..8) {
            list.add(PokemonUI("Pikachu $i"))
        }
        return list
    }
}