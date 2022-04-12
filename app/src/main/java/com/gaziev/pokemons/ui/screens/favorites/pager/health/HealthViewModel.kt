package com.gaziev.pokemons.ui.screens.favorites.pager.health

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.domain.models.PokemonBD
import com.gaziev.domain.usecases.get.GetFavoritePokemonsUseCase
import com.gaziev.domain.usecases.search.SearchDataInObjectFieldsUseCase
import com.gaziev.domain.usecases.sort.SortHealthFavoritePokemonsUseCase

class HealthViewModel(
    private val getFavoritePokemonsUseCase: GetFavoritePokemonsUseCase,
    private val sortHealthFavoritePokemonsUseCase: SortHealthFavoritePokemonsUseCase,
    private val searchDataInObjectFieldsUseCase: SearchDataInObjectFieldsUseCase<PokemonBD>

) : ViewModel() {

    private var _pokemons: MutableLiveData<List<PokemonBD>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<PokemonBD>> = _pokemons
    private var listFromBD: List<PokemonBD> = emptyList()
    private var listSearch: List<PokemonBD> = emptyList()
    private var stateSortedUp: Boolean = true

    init {
        listFromBD = getFavoritePokemonsUseCase.get()
        _pokemons.value = sortHealthFavoritePokemonsUseCase.up(listFromBD)
    }

    fun sortItems() {
        if (stateSortedUp) {
            _pokemons.value = sortHealthFavoritePokemonsUseCase.down(pokemons.value!!)
        } else {
            _pokemons.value = sortHealthFavoritePokemonsUseCase.up(pokemons.value!!)
        }
        stateSortedUp = !stateSortedUp
    }

    fun search(text: String) {
        listSearch = searchDataInObjectFieldsUseCase.search(listFromBD, text)
        _pokemons.value = listSearch
    }

    fun endSearch() {
        _pokemons.value = listFromBD
    }

}