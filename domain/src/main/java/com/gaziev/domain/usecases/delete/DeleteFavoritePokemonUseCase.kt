package com.gaziev.domain.usecases.delete

import com.gaziev.domain.dispatcher.DispatcherCoroutine
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteFavoritePokemonUseCase @Inject constructor(
    private val repository: PokemonRepository,
    private val dispatcher: DispatcherCoroutine
) {

    suspend fun deleteFavoritePokemon(idPokemon: String) =
        withContext(dispatcher.get()) {
            return@withContext repository.delete(idPokemon)
        }
}