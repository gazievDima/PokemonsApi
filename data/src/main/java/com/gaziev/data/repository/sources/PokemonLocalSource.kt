package com.gaziev.data.repository.sources

import com.gaziev.data.models.PokemonLocalEntity
import kotlinx.coroutines.flow.Flow

interface PokemonLocalSource {

     suspend fun getCachePokemons(): Flow<List<PokemonLocalEntity>> = TODO()
     suspend fun getFavoritesPokemons(): Flow<List<PokemonLocalEntity>> = TODO()
     suspend fun deletePokemon(pokemon: PokemonLocalEntity): Boolean = TODO()
     suspend fun savePokemon(pokemon: PokemonLocalEntity): Boolean = TODO()
}