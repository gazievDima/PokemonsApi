package com.gaziev.domain.usecases.save

import com.gaziev.domain.models.PokemonBD
import com.gaziev.domain.repository.ISaveFavoritePokemonRepository

class SaveFavoritePokemonUseCase(
    private val storage: ISaveFavoritePokemonRepository
) {

    fun saveFavoritePokemon(pokemon: PokemonBD): Boolean {
        return storage.save(pokemon)
    }
}