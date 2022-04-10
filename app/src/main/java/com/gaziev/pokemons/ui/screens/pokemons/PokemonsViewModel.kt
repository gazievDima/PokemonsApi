package com.gaziev.pokemons.ui.screens.pokemons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.pokemons.models.Pokemon
import com.gaziev.pokemons.repository.GetApiPokemons

class PokemonsViewModel(
    private val getApiPokemons: GetApiPokemons
) : ViewModel() {

    private var _pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<Pokemon>> = _pokemons

    init {
        _pokemons.value = getApiPokemons.get()
    }

}