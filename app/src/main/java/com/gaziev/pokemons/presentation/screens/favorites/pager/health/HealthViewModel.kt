package com.gaziev.pokemons.presentation.screens.favorites.pager.health

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.domain.models.PokemonLocal
import com.gaziev.domain.usecases.get.GetFavoritesPokemonsUseCase
import com.gaziev.domain.usecases.search.SearchInFieldsDetailsUseCase
import com.gaziev.domain.usecases.sort.SortedPokemonsByHealthUseCase
import javax.inject.Inject

class HealthViewModel @Inject constructor(
    private val getFavoritePokemonsUseCase: GetFavoritesPokemonsUseCase,
    private val sortHealthFavoritePokemonsUseCase: SortedPokemonsByHealthUseCase,
    private val searchDataInObjectFieldsUseCase: SearchInFieldsDetailsUseCase<PokemonLocal>

) : ViewModel() {

    private var _pokemons: MutableLiveData<List<PokemonLocal>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<PokemonLocal>> = _pokemons
    private var listFromBD: List<PokemonLocal> = emptyList()
    private var listSearch: List<PokemonLocal> = emptyList()
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