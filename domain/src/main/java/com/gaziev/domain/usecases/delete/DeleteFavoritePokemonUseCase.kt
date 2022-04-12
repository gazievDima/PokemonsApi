package com.gaziev.domain.usecases.delete

import com.gaziev.domain.models.PokemonBD
import com.gaziev.domain.repository.IDeleteFavoritePokemonRepository

class DeleteFavoritePokemonUseCase(
    private val storage: IDeleteFavoritePokemonRepository
) {

    fun deleteFavoritePokemon(pokemon: PokemonBD): Boolean {
       return storage.delete(pokemon)
    }
}