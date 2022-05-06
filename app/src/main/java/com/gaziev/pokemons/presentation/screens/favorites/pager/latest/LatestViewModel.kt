package com.gaziev.pokemons.presentation.screens.favorites.pager.latest

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.usecases.get.GetFavoritesPokemonsUseCase
import com.gaziev.domain.usecases.search.SearchInFieldsDetailsUseCase
import com.gaziev.domain.usecases.sort.SortedPokemonsByLatestUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LatestViewModel @Inject constructor(
    private val getFavoritePokemonsUseCase: GetFavoritesPokemonsUseCase,
    private val sortLatestFavoritePokemonsUseCase: SortedPokemonsByLatestUseCase,
    private val searchDataInObjectFieldsUseCase: SearchInFieldsDetailsUseCase<PokemonLocalDetails>
) : ViewModel() {

    private var _pokemons = MutableLiveData<List<PokemonLocalDetails>>()
    val pokemons: LiveData<List<PokemonLocalDetails>> = _pokemons
    private var listFromBD: List<PokemonLocalDetails> = emptyList()
    private var listSearch: List<PokemonLocalDetails> = emptyList()
    private var stateSortedUp: Boolean = true

    fun getPokemons() {
        viewModelScope.launch {
            getFavoritePokemonsUseCase.get()
                .collect { list ->
                    listFromBD = list
                    _pokemons.value = sortLatestFavoritePokemonsUseCase.down(listFromBD)
                }
        }
    }

    fun sortItems() {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                val list = mutableListOf<PokemonLocalDetails>()
                if (stateSortedUp) {
                    list.addAll(sortLatestFavoritePokemonsUseCase.down(pokemons.value!!))
                } else {
                    list.addAll(sortLatestFavoritePokemonsUseCase.up(pokemons.value!!))
                }
                Log.i(TAG, "equals = " + list.equals(_pokemons.value).toString())
                _pokemons.value = list
                stateSortedUp = !stateSortedUp
                Log.i(TAG, pokemons.value.toString())
            }
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

    fun resetNumbersForView(list: List<PokemonLocalDetails>): Map<Int, Int> {
        val mapNumbers = mutableMapOf<Int, Int>()

        if (list.first().primary_key!! > list.last().primary_key!!) {
            var count = list.size
            for (el in list) {
                mapNumbers[el.primary_key!!] = count
                count -= 1
            }
        } else {
            var count = 1
            for (el in list) {
                mapNumbers[el.primary_key!!] = count
                count += 1
            }
        }
        return mapNumbers
    }

}