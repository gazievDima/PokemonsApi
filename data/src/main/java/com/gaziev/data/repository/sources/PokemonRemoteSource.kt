package com.gaziev.data.repository.sources

import com.gaziev.data.models.PokemonRemoteEntity
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteSource {

    suspend fun getPokemons(): Flow<List<PokemonRemoteEntity>>
    suspend fun getPagePokemons(page: Int, pageSize: Int): Flow<List<PokemonRemoteEntity>>
}