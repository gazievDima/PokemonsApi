package com.gaziev.pokemons.ui.screens.favorites.pager.latest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.pokemons.models.Pokemon
import com.gaziev.pokemons.repository.GetFavoritePokemons

class LatestViewModel(
    private val getFavoritePokemons: GetFavoritePokemons
) : ViewModel() {

    private var _pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<Pokemon>> = _pokemons

    init {
        _pokemons.value = getFavoritePokemons.get()
    }

}