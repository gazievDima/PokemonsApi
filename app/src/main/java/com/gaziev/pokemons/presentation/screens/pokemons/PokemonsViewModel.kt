package com.gaziev.pokemons.presentation.screens.pokemons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.usecases.get.GetPokemonsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonsViewModel @Inject constructor(
    private val getApiPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    private var _pokemons: MutableLiveData<List<PokemonRemoteDetails>> = MutableLiveData()
    val pokemons: LiveData<List<PokemonRemoteDetails>> = _pokemons

    init {
        viewModelScope.launch {
            getApiPokemonsUseCase.get()
                .collect { list ->
                    _pokemons.value = list
                }

        }
    }

}