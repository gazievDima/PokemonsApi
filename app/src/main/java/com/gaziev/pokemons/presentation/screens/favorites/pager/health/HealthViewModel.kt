package com.gaziev.pokemons.presentation.screens.favorites.pager.health

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.usecases.get.GetFavoritesPokemonsUseCase
import com.gaziev.domain.usecases.search.SearchInFieldsDetailsUseCase
import com.gaziev.domain.usecases.sort.SortedPokemonsByHealthUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HealthViewModel @Inject constructor(
    private val getFavoritePokemonsUseCase: GetFavoritesPokemonsUseCase,
    private val sortHealthFavoritePokemonsUseCase: SortedPokemonsByHealthUseCase,
    private val searchDataInObjectFieldsUseCase: SearchInFieldsDetailsUseCase<PokemonLocalDetails>

) : ViewModel() {

    private var _pokemons: MutableLiveData<List<PokemonLocalDetails>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<PokemonLocalDetails>> = _pokemons
    private var listFromBD: List<PokemonLocalDetails> = emptyList()
    private var listSearch: List<PokemonLocalDetails> = emptyList()
    private var stateSortedUp: Boolean = true

    init {
        viewModelScope.launch {
                getFavoritePokemonsUseCase.get()
                    .collect { list ->
                        listFromBD = list
                        _pokemons.value = sortHealthFavoritePokemonsUseCase.up(listFromBD)
                    }
        }
    }

    fun sortItems() {
        viewModelScope.launch {
            if (stateSortedUp) {
                _pokemons.value = sortHealthFavoritePokemonsUseCase.down(pokemons.value!!)
            } else {
                _pokemons.value = sortHealthFavoritePokemonsUseCase.up(pokemons.value!!)
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