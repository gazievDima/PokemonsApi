package com.gaziev.domain.usecases.save

import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.domain.models.PokemonBDDao
import com.gaziev.domain.repository.ISaveFavoritePokemonRepository

class SaveFavoritePokemonUseCase(
    private val storage: ISaveFavoritePokemonRepository
) {

    fun saveFavoritePokemon(pokemon: PokemonBDDao): Boolean {
        return storage.save(pokemon)
    }
}