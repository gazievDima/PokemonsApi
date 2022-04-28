package com.gaziev.domain.usecases.get

import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetFavoritesPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository,
) {

    suspend fun get(): Flow<List<PokemonLocalDetails>> = withContext(Dispatchers.Default) {
        return@withContext repository.getFavoritesPokemons()
    }
}