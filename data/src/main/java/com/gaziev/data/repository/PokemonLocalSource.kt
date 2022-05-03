package com.gaziev.data.repository

import com.gaziev.data.models.PokemonLocalEntity
import kotlinx.coroutines.flow.Flow

interface PokemonLocalSource {

     suspend fun getCachePokemons(): Flow<List<PokemonLocalEntity>>
     suspend fun getFavoritesPokemons(): Flow<List<PokemonLocalEntity>>
     suspend fun deletePokemon(pokemon: PokemonLocalEntity): Boolean
     suspend fun savePokemon(pokemon: PokemonLocalEntity): Boolean
}