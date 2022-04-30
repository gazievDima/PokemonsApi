package com.gaziev.data.sources.remote

import android.content.ContentValues.TAG
import android.util.Log
import com.gaziev.data.BuildConfig
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.models.PokemonsRetrofitEntity
import com.gaziev.data.repository.sources.PokemonRemoteSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRemoteSourceImpl @Inject constructor(
    private val pokemonsApiService: PokemonsApiService
) : PokemonRemoteSource {

    override suspend fun getPokemons(): Flow<List<PokemonRemoteEntity>> = flow {
        try {
            val response: PokemonsRetrofitEntity
            = pokemonsApiService.getPokemonsCards(BuildConfig.API_KEY)
            if (response.data == null) emit(emptyList()) else emit(response.data)
        } catch (e: Exception) {
            emit(emptyList())
        }
    }

    override suspend fun getPagePokemons(page: Int, pageSize: Int): Flow<List<PokemonRemoteEntity>> = flow {
        try {
            val response: PokemonsRetrofitEntity
            = pokemonsApiService.getPagePokemonsCards(BuildConfig.API_KEY, page, pageSize)
            if (response.data == null) emit(emptyList()) else emit(response.data)
        } catch (e: Exception) {
            emit(emptyList())
        }
    }

}