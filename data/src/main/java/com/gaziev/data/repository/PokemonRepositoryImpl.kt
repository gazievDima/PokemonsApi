package com.gaziev.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.gaziev.data.repository.mapper.Mapper
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.repository.sources.PokemonLocalSource
import com.gaziev.data.sources.remote.PokemonsPagingSourceImpl
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
    private val pagingSource: PokemonsPagingSourceImpl,
    private val pokemonLocalMapper: Mapper<PokemonLocalEntity, PokemonLocalDetails>,
    private val dispatcher: DispatcherData
) : PokemonRepository {

    override suspend fun getPokemons(): Flow<PagingData<PokemonRemoteDetails>> =
        Pager(PagingConfig(
            pageSize = 10,
            enablePlaceholders = true
        )) {
            pagingSource
        }.flow


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









