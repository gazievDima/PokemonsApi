package com.gaziev.domain.repository

import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun getPokemons(): Flow<List<PokemonRemoteDetails>>
    suspend fun getFavoritesPokemons(): Flow<List<PokemonLocalDetails>>
    suspend fun delete(pokemon: PokemonLocalDetails): Boolean
    suspend fun save(pokemon: PokemonLocalDetails): Boolean

}