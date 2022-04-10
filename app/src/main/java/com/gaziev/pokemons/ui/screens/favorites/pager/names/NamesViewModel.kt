package com.gaziev.pokemons.ui.screens.favorites.pager.names

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.pokemons.core.models.common.Pokemon
import com.gaziev.pokemons.ui.usecase.GetPokemonsUseCase
import com.gaziev.pokemons.ui.usecase.SaveFavoritePokemonUseCase

class NamesViewModel : ViewModel() {

    lateinit var getFavoritePokemonsUseCase: GetPokemonsUseCase

    private var _pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<Pokemon>> = _pokemons

    init {
        _pokemons.value = getFavoritePokemonsUseCase.getPokemons()
    }

}