package com.gaziev.domain.usecases.delete

import com.gaziev.domain.models.Pokemon
import com.gaziev.domain.repository.IDeleteFavoritePokemonRepository

class DeleteFavoritePokemonUseCase(
    private val storage: IDeleteFavoritePokemonRepository
) {

    fun deleteFavoritePokemon(pokemon: Pokemon): Boolean {
       return storage.delete(pokemon)
    }
}