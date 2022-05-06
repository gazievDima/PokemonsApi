package com.gaziev.domain.usecases.search

import com.gaziev.domain.repository.PokemonRepository
import com.gaziev.domain.usecases.DispatcherDomain
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchFavoritePokemonUseCase @Inject constructor(
    private val repository: PokemonRepository,
    private val dispatcher: DispatcherDomain
) {
    suspend fun searchFavoritePokemon(idPokemon: String): Boolean = withContext(dispatcher.inject()) {
        val list = repository.search(idPokemon)
        return@withContext list.isNotEmpty()
    }
}