package com.gaziev.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.sources.local.PokemonDao
import com.gaziev.data.sources.remote.PokemonsPagingSourceImpl
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val localSource: PokemonDao,
    private val remoteSource: PokemonsPagingSourceImpl,
    private val pokemonLocalMapper: Mapper<PokemonLocalEntity, PokemonLocalDetails>,
    private val dispatcher: DispatcherData
) : PokemonRepository {

    override suspend fun getPokemons(): Flow<PagingData<PokemonRemoteDetails>> =
        withContext(dispatcher.inject()) {
            Pager(
                PagingConfig(
                    pageSize = 10,
                    enablePlaceholders = true
                )
            ) {
                remoteSource
            }.flow
        }


    override suspend fun getFavoritesPokemons(): Flow<List<PokemonLocalDetails>> =
        withContext(dispatcher.inject()) {
            return@withContext flow {
                val result = localSource.getAll()
                    .map {
                        pokemonLocalMapper.mapTo(it)
                    }
                emit(result)
            }

        }

    override suspend fun save(pokemon: PokemonLocalDetails) = withContext(Dispatchers.IO) {
        return@withContext localSource.insert(pokemonLocalMapper.mapFrom(pokemon))
    }

    override suspend fun delete(pokemon: PokemonLocalDetails) = withContext(Dispatchers.IO) {
        return@withContext localSource.delete(pokemonLocalMapper.mapFrom(pokemon))
    }

}









