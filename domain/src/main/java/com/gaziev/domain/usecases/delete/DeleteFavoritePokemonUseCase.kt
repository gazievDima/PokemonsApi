package com.gaziev.domain.usecases.delete

import com.gaziev.domain.models.Pokemon
import com.gaziev.domain.repository.DeleteFavoritePokemonRepository

class DeleteFavoritePokemonUseCase(
    private val storage: DeleteFavoritePokemonRepository
) {

    fun deleteFavoritePokemon(pokemon: Pokemon): Boolean {
       return storage.delete(pokemon)
    }
}