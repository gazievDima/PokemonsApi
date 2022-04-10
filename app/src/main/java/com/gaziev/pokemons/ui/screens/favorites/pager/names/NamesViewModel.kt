package com.gaziev.pokemons.ui.screens.favorites.pager.names

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.domain.usecases.get.GetFavoritePokemonsUseCase

class NamesViewModel(
    private val getFavoritePokemonsUseCase: GetFavoritePokemonsUseCase
) : ViewModel() {

    private var _pokemons: MutableLiveData<List<com.gaziev.domain.models.Pokemon>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<com.gaziev.domain.models.Pokemon>> = _pokemons

    init {
        _pokemons.value = getFavoritePokemonsUseCase.get()
    }

}