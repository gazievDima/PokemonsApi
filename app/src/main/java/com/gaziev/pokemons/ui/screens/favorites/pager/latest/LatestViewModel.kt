package com.gaziev.pokemons.ui.screens.favorites.pager.latest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.domain.models.PokemonBDDao
import com.gaziev.domain.usecases.get.GetFavoritePokemonsUseCase
import com.gaziev.domain.usecases.sort.SortLatestFavoritePokemonsUseCase

class LatestViewModel(
    private val getFavoritePokemonsUseCase: GetFavoritePokemonsUseCase,
    private val sortLatestFavoritePokemonsUseCase: SortLatestFavoritePokemonsUseCase
) : ViewModel() {

    private var stateSortedUp: Boolean = true
    private var _pokemons: MutableLiveData<List<PokemonBDDao>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<PokemonBDDao>> = _pokemons

    init {
        val listPokemons = getFavoritePokemonsUseCase.get()
        _pokemons.value = sortLatestFavoritePokemonsUseCase.up(listPokemons)
    }

    fun sortItems() {
        if (stateSortedUp) {
            _pokemons.value = sortLatestFavoritePokemonsUseCase.down(pokemons.value!!)
        } else {
            _pokemons.value = sortLatestFavoritePokemonsUseCase.up(pokemons.value!!)
        }
        stateSortedUp = !stateSortedUp
    }

}