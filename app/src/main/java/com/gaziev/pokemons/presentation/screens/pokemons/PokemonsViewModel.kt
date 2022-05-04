package com.gaziev.pokemons.presentation.screens.pokemons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.usecases.delete.DeleteFavoritePokemonUseCase
import com.gaziev.domain.usecases.get.GetPokemonsUseCase
import com.gaziev.domain.usecases.save.SaveFavoritePokemonUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class PokemonsViewModel @Inject constructor(
    private val getApiPokemonsUseCase: GetPokemonsUseCase,
    private val saveFavoritePokemonUseCase: SaveFavoritePokemonUseCase,
    private val mapper: Mapper<PokemonRemoteDetails, PokemonLocalDetails>
) : ViewModel() {

    suspend fun pokemons(): Flow<PagingData<PokemonRemoteDetails>> =
        getApiPokemonsUseCase.get().cachedIn(viewModelScope)

    suspend fun savePokemons(pokemon: PokemonRemoteDetails) {
        saveFavoritePokemonUseCase.saveFavoritePokemon(mapper.mapTo(pokemon))
    }
}