package com.gaziev.data.repository

import com.gaziev.data.mapper.IMapper
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.repository.sources.PokemonLocalSource
import com.gaziev.data.repository.sources.PokemonRemoteSource
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val localSource: PokemonLocalSource,
    private val remoteSource: PokemonRemoteSource,
    private val pokemonLocalMapper: IMapper<PokemonLocalEntity, PokemonLocalDetails>,
    private val pokemonRemoteMapper: IMapper<PokemonRemoteEntity, PokemonRemoteDetails>,
) : PokemonRepository {

    override suspend fun getPokemons(): Flow<List<PokemonRemoteDetails>> = withContext(Dispatchers.IO) {
        return@withContext remoteSource.getPokemons()
            .map { list ->
                list.map { pokemon ->
                    pokemonRemoteMapper.mapTo(pokemon) }
            }
    }

    override suspend fun getFavoritesPokemons(): Flow<List<PokemonLocalDetails>> = withContext(Dispatchers.IO) {
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









