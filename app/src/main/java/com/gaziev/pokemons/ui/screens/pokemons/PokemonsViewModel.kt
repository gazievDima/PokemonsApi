package com.gaziev.pokemons.ui.screens.pokemons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.domain.usecases.get.GetApiPokemonsUseCase

class PokemonsViewModel(
    private val getApiPokemonsUseCase: GetApiPokemonsUseCase
) : ViewModel() {

    private var _pokemons: MutableLiveData<List<PokemonApiDao>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<PokemonApiDao>> = _pokemons

    init {
        _pokemons.value = getApiPokemonsUseCase.get()
    }

}