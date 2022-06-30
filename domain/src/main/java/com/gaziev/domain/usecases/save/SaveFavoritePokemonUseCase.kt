package com.gaziev.domain.usecases.save

import com.gaziev.domain.dispatcher.DispatcherCoroutine
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveFavoritePokemonUseCase @Inject constructor(
    private val repository: PokemonRepository,
    private val dispatcher: DispatcherCoroutine
) {

    suspend fun saveFavoritePokemon(pokemon: PokemonLocalDetails) =
        withContext(dispatcher.get()) {
            return@withContext repository.save(pokemon)
        }
}