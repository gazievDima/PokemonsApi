package com.gaziev.pokemons.ui.screens.favorites.pager.names

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.domain.models.PokemonBDDao
import com.gaziev.domain.usecases.get.GetFavoritePokemonsUseCase
import com.gaziev.domain.usecases.sort.SortNamesFavoritePokemonsUseCase

class NamesViewModel(
    private val getFavoritePokemonsUseCase: GetFavoritePokemonsUseCase,
    private val sortNamesFavoritePokemonsUseCase: SortNamesFavoritePokemonsUseCase
) : ViewModel() {

    private var stateSortedUp: Boolean = true
    private var _pokemons: MutableLiveData<List<PokemonBDDao>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<PokemonBDDao>> = _pokemons

    init {
        val listPokemons = getFavoritePokemonsUseCase.get()
        _pokemons.value = sortNamesFavoritePokemonsUseCase.up(listPokemons)
    }

    fun sortItems() {
        if (stateSortedUp) {
            _pokemons.value = sortNamesFavoritePokemonsUseCase.down(pokemons.value!!)
        } else {
            _pokemons.value = sortNamesFavoritePokemonsUseCase.up(pokemons.value!!)
        }
        stateSortedUp = !stateSortedUp
    }

}