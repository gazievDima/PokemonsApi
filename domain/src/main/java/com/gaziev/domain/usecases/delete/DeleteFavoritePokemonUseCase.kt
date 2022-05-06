package com.gaziev.domain.usecases.delete

import com.gaziev.domain.usecases.DispatcherDomain
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteFavoritePokemonUseCase @Inject constructor(
    private val repository: PokemonRepository,
    private val dispatcher: DispatcherDomain
) {

    suspend fun deleteFavoritePokemon(idPokemon: String) =
        withContext(dispatcher.inject()) {
            return@withContext repository.delete(idPokemon)
        }
}