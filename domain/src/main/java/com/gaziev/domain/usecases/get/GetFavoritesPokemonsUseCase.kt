package com.gaziev.domain.usecases.get

import com.gaziev.domain.common.DispatcherDomain
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetFavoritesPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository,
    private val dispatcher: DispatcherDomain
) {

    suspend fun get(): Flow<List<PokemonLocalDetails>> = withContext(dispatcher.inject()) {
        return@withContext repository.getFavoritesPokemons()
    }
}