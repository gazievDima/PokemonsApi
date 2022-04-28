package com.gaziev.domain.usecases.delete

import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteFavoritePokemonUseCase @Inject constructor(
    private val repository: PokemonRepository,
) {

    suspend fun deleteFavoritePokemon(pokemon: PokemonLocalDetails): Boolean = withContext(Dispatchers.Default) {
        return@withContext repository.delete(pokemon)
    }
}