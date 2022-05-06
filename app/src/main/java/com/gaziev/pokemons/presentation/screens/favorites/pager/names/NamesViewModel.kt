package com.gaziev.pokemons.presentation.screens.favorites.pager.names

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.usecases.get.GetFavoritesPokemonsUseCase
import com.gaziev.domain.usecases.search.SearchInFieldsDetailsUseCase
import com.gaziev.domain.usecases.sort.SortedPokemonsByNamesUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class NamesViewModel @Inject constructor(
    private val getFavoritePokemonsUseCase: GetFavoritesPokemonsUseCase,
    private val sortNamesFavoritePokemonsUseCase: SortedPokemonsByNamesUseCase,
    private val searchDataInObjectFieldsUseCase: SearchInFieldsDetailsUseCase<PokemonLocalDetails>
) : ViewModel() {

    private var _pokemons: MutableLiveData<List<PokemonLocalDetails>> = MutableLiveData()
    val pokemons: LiveData<List<PokemonLocalDetails>> = _pokemons
    private var listFromBD: List<PokemonLocalDetails> = emptyList()
    private var listSearch: List<PokemonLocalDetails> = emptyList()
    private var stateSortedUp: Boolean = true

    fun getPokemons() {
        viewModelScope.launch {
            getFavoritePokemonsUseCase.get()
                .collect { list ->
                    listFromBD = list
                    _pokemons.value = sortNamesFavoritePokemonsUseCase.up(listFromBD)
                }
        }
    }

    fun sortItems() {
        viewModelScope.launch {
            if (stateSortedUp) {
                _pokemons.value = sortNamesFavoritePokemonsUseCase.down(pokemons.value!!)
            } else {
                _pokemons.value = sortNamesFavoritePokemonsUseCase.up(pokemons.value!!)
            }
            stateSortedUp = !stateSortedUp
        }
    }

    fun search(text: String) {
        viewModelScope.launch {
            listSearch = searchDataInObjectFieldsUseCase.search(listFromBD, text)
            _pokemons.value = listSearch
        }
    }

    fun endSearch() {
        _pokemons.value = listFromBD
    }

}