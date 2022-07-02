package com.gaziev.domain.usecases.get

import com.gaziev.domain.dispatcher.DispatcherCoroutine
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetFavoritesPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository,
    private val dispatcher: DispatcherCoroutine
) {

    suspend fun get(): List<PokemonLocalDetails> = withContext(dispatcher.get()) {
        return@withContext repository.getFavoritesPokemons()
    }
}