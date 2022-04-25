package com.gaziev.pokemons.presentation.screens.pokemons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.domain.models.PokemonRemote
import com.gaziev.domain.usecases.get.GetPokemonsUseCase
import javax.inject.Inject

class PokemonsViewModel @Inject constructor(
    private val getApiPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    private var _pokemons: MutableLiveData<List<PokemonRemote>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<PokemonRemote>> = _pokemons

    init {
        _pokemons.value = getApiPokemonsUseCase.get()
    }

}