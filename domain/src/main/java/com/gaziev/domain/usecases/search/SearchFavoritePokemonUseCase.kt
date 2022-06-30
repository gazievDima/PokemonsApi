package com.gaziev.domain.usecases.search

import com.gaziev.domain.dispatcher.DispatcherCoroutine
import com.gaziev.domain.repository.PokemonRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchFavoritePokemonUseCase @Inject constructor(
    private val repository: PokemonRepository,
    private val dispatcher: DispatcherCoroutine
) {
    suspend fun searchFavoritePokemon(idPokemon: String): Boolean = withContext(dispatcher.get()) {
        val list = repository.search(idPokemon)
        return@withContext list.isNotEmpty()
    }
}