package com.gaziev.domain.usecases.save

import com.gaziev.domain.models.Pokemon
import com.gaziev.domain.repository.SaveFavoritePokemonRepository

class SaveFavoritePokemonUseCase(
    private val storage: SaveFavoritePokemonRepository
) {

    fun saveFavoritePokemon(pokemon: Pokemon): Boolean {
        return storage.save(pokemon)
    }
}