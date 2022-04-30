package com.gaziev.data.sources.remote

import android.content.ContentValues.TAG
import android.util.Log
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.repository.sources.PokemonRemoteSource
import com.gaziev.data.sources.remote.retrofit.PokemonsRetrofitEntity
import com.gaziev.data.sources.remote.retrofit.PokemonsApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRemoteSourceImpl @Inject constructor(
    private val pokemonsApiService: PokemonsApiService
) : PokemonRemoteSource {

    override suspend fun getPokemons(): Flow<List<PokemonRemoteEntity>> = flow {
        try {
            val response: PokemonsRetrofitEntity = pokemonsApiService.getPokemonsCard()
            if (response.data == null) emit(emptyList()) else emit(response.data)
        } catch (e: Exception) {
            Log.e(TAG, "Connection failed: $e")
            emit(emptyList())
        }
    }

    override suspend fun getPagePokemons(page: Int, pageSize: Int): Flow<List<PokemonRemoteEntity>> = flow {
        try {
            val response: PokemonsRetrofitEntity = pokemonsApiService.getPagePokemonsCards(page, pageSize)
            if (response.data == null) emit(emptyList()) else emit(response.data)
        } catch (e: Exception) {
            Log.e(TAG, "Connection failed: $e")
            emit(emptyList())
        }
    }

}