package com.gaziev.pokemons.presentation.screens.favorites.pager.latest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.domain.models.PokemonLocal
import com.gaziev.domain.usecases.get.GetFavoritesPokemonsUseCase
import com.gaziev.domain.usecases.search.SearchInFieldsDetailsUseCase
import com.gaziev.domain.usecases.sort.SortedPokemonsByLatestUseCase
import javax.inject.Inject

class LatestViewModel @Inject constructor(
    private val getFavoritePokemonsUseCase: GetFavoritesPokemonsUseCase,
    private val sortLatestFavoritePokemonsUseCase: SortedPokemonsByLatestUseCase,
    private val searchDataInObjectFieldsUseCase: SearchInFieldsDetailsUseCase<PokemonLocal>
) : ViewModel() {

    private var _pokemons: MutableLiveData<List<PokemonLocal>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<PokemonLocal>> = _pokemons
    private var listFromBD: List<PokemonLocal> = emptyList()
    private var listSearch: List<PokemonLocal> = emptyList()
    private var stateSortedUp: Boolean = true

    init {
        listFromBD = getFavoritePokemonsUseCase.get()
        _pokemons.value = sortLatestFavoritePokemonsUseCase.up(listFromBD)
    }

    fun sortItems() {
        if (stateSortedUp) {
            _pokemons.value = sortLatestFavoritePokemonsUseCase.down(pokemons.value!!)
        } else {
            _pokemons.value = sortLatestFavoritePokemonsUseCase.up(pokemons.value!!)
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