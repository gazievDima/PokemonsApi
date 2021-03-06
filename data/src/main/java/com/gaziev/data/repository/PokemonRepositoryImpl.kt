package com.gaziev.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gaziev.data.dispatcher.DispatcherCoroutine
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.sources.local.PokemonDao
import com.gaziev.data.sources.remote.PokemonsPagingSourceImpl
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val localSource: PokemonDao,
    private val remoteSource: PokemonsPagingSourceImpl,
    private val pokemonLocalMapper: Mapper<PokemonLocalEntity, PokemonLocalDetails>,
    private val dispatcher: DispatcherCoroutine
) : PokemonRepository {

    override suspend fun getPokemons(): Flow<PagingData<PokemonRemoteDetails>> =
        withContext(dispatcher.get()) {
            Pager(
                PagingConfig(
                    pageSize = 10,
                    enablePlaceholders = true
                )
            ) {
                remoteSource
            }.flow
        }


    override suspend fun getFavoritesPokemons(): List<PokemonLocalDetails> =
        withContext(dispatcher.get()) {
            return@withContext localSource.getAll()
                .map {
                    pokemonLocalMapper.mapTo(it)
                }
        }


    override suspend fun save(pokemon: PokemonLocalDetails) = withContext(Dispatchers.IO) {
        return@withContext localSource.insert(pokemonLocalMapper.mapFrom(pokemon))
    }

    override suspend fun delete(idPokemon: String) = withContext(Dispatchers.IO) {
        return@withContext localSource.delete(idPokemon)
    }

    override suspend fun search(idPokemon: String): List<PokemonLocalDetails> =
        withContext(dispatcher.get()) {
            return@withContext localSource.search(idPokemon).map {
                pokemonLocalMapper.mapTo(it)
            }
        }

}









