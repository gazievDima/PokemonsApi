package com.gaziev.domain.usecases.save

import com.gaziev.domain.models.Pokemon
import com.gaziev.domain.repository.ISaveFavoritePokemonRepository

class SaveFavoritePokemonUseCase(
    private val storage: ISaveFavoritePokemonRepository
) {

    fun saveFavoritePokemon(pokemon: Pokemon): Boolean {
        return storage.save(pokemon)
    }
}