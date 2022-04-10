package com.gaziev.pokemons.ui.screens.pokemons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.pokemons.core.models.common.Pokemon
import com.gaziev.pokemons.ui.usecase.GetPokemonsUseCase

class PokemonsViewModel(
) : ViewModel() {
    lateinit var getPokemonsUseCase: GetPokemonsUseCase

    private var _pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<Pokemon>> = _pokemons

    init {
        _pokemons.value = getPokemonsUseCase.getPokemons()
    }

}