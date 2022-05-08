package com.gaziev.pokemons.presentation.screens.pokemons

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.usecases.delete.DeleteFavoritePokemonUseCase
import com.gaziev.domain.usecases.get.GetPokemonsUseCase
import com.gaziev.domain.usecases.save.SaveFavoritePokemonUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonsViewModel @Inject constructor(
    private val getApiPokemonsUseCase: GetPokemonsUseCase,
) : ViewModel() {

    private val _pokemons: MutableLiveData<PagingData<PokemonRemoteDetails>> = MutableLiveData()
    val pokemons: LiveData<PagingData<PokemonRemoteDetails>> = _pokemons

    init {
        viewModelScope.launch {
            getPokemons()
        }
    }

    private suspend fun getPokemons() {
        getApiPokemonsUseCase
            .get()
            .cachedIn(viewModelScope)
            .collectLatest {
                _pokemons.value = it
            }
    }

}