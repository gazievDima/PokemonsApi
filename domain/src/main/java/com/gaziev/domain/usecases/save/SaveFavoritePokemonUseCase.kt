package com.gaziev.domain.usecases.save

import com.gaziev.domain.usecases.DispatcherDomain
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveFavoritePokemonUseCase @Inject constructor(
    private val storage: PokemonRepository,
    private val dispatcher: DispatcherDomain
) {

    suspend fun saveFavoritePokemon(pokemon: PokemonLocalDetails): Boolean = withContext(dispatcher.inject()) {
        return@withContext storage.save(pokemon)
    }
}