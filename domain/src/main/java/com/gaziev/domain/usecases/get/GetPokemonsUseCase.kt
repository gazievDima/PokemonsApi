package com.gaziev.domain.usecases.get

import androidx.paging.PagingData
import com.gaziev.domain.dispatcher.DispatcherCoroutine
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository,
    private val dispatcher: DispatcherCoroutine
) {

    suspend fun get(): Flow<PagingData<PokemonRemoteDetails>> = withContext(dispatcher.get()) {
        return@withContext repository.getPokemons()
    }
}