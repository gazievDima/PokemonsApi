package com.gaziev.domain.usecases.get

import com.gaziev.domain.common.DispatcherDomain
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository,
    private val dispatcher: DispatcherDomain
) {

    suspend fun get(): Flow<List<PokemonRemoteDetails>> = withContext(dispatcher.inject()) {
        return@withContext repository.getPokemons()
    }
}