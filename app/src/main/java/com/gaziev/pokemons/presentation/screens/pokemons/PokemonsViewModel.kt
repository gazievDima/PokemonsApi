package com.gaziev.pokemons.presentation.screens.pokemons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.gaziev.data.sources.remote.PokemonsPagingSourceImpl
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.usecases.get.GetPokemonsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonsViewModel @Inject constructor(
    private val getApiPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    suspend fun pokemons(): Flow<PagingData<PokemonRemoteDetails>> =
        getApiPokemonsUseCase.get().cachedIn(viewModelScope)

}