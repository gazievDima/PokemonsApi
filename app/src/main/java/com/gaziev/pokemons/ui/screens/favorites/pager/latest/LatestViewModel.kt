package com.gaziev.pokemons.ui.screens.favorites.pager.latest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.domain.usecases.get.GetFavoritePokemonsUseCase

class LatestViewModel(
    private val getFavoritePokemonsUseCase: GetFavoritePokemonsUseCase
) : ViewModel() {

    private var _pokemons: MutableLiveData<List<com.gaziev.domain.models.PokemonApiDao>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<com.gaziev.domain.models.PokemonApiDao>> = _pokemons

    init {
        _pokemons.value = getFavoritePokemonsUseCase.get()
    }

}