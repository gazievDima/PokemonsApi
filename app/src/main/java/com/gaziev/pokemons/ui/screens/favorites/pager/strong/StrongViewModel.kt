package com.gaziev.pokemons.ui.screens.favorites.pager.strong

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.pokemons.PokemonApi
import com.gaziev.pokemons.ui.models.PokemonUI

class StrongViewModel : ViewModel() {
    private var _pokemons: MutableLiveData<List<PokemonUI>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<PokemonUI>> = _pokemons

    init {
        _pokemons.value = PokemonApi.getPokemonsList()
    }

}