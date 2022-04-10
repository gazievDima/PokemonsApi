package com.gaziev.domain.usecases.save

import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.domain.repository.ISaveFavoritePokemonRepository

class SaveFavoritePokemonUseCase(
    private val storage: ISaveFavoritePokemonRepository
) {

    fun saveFavoritePokemon(pokemon: PokemonApiDao): Boolean {
        return storage.save(pokemon)
    }
}