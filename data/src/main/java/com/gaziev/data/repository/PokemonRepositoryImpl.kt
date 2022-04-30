package com.gaziev.data.repository

import com.gaziev.data.repository.mapper.Mapper
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.repository.sources.PokemonLocalSource
import com.gaziev.data.repository.sources.PokemonRemoteSource
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val localSource: PokemonLocalSource,
    private val remoteSource: PokemonRemoteSource,
    private val pokemonLocalMapper: Mapper<PokemonLocalEntity, PokemonLocalDetails>,
    private val pokemonRemoteMapper: Mapper<PokemonRemoteEntity, PokemonRemoteDetails>,
    private val dispatcher: DispatcherData
) : PokemonRepository {

    override suspend fun getPokemons(): Flow<List<PokemonRemoteDetails>> = withContext(dispatcher.inject()) {
        return@withContext remoteSource.getPagePokemons(1, 10)
            .map { list ->
                list.map { pokemon ->
                    pokemonRemoteMapper.mapTo(pokemon) }
            }
    }

    override suspend fun getFavoritesPokemons(): Flow<List<PokemonLocalDetails>> = withContext(dispatcher.inject()) {
        return@withContext localSource.getFavoritesPokemons()
            .map { list ->
                list.map { pokemon ->
                    pokemonLocalMapper.mapTo(pokemon)
                }
            }
    }

    override suspend fun save(pokemon: PokemonLocalDetails): Boolean = withContext(Dispatchers.IO) {
        return@withContext localSource.savePokemon(pokemonLocalMapper.mapFrom(pokemon))
    }

    override suspend fun delete(pokemon: PokemonLocalDetails): Boolean = withContext(Dispatchers.IO) {
        return@withContext localSource.deletePokemon(pokemonLocalMapper.mapFrom(pokemon))
    }

}









