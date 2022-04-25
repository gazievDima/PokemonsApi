package com.gaziev.domain.usecases.save

import com.gaziev.domain.models.PokemonLocal
import com.gaziev.domain.repository.PokemonRepository
import javax.inject.Inject

class SaveFavoritePokemonUseCase @Inject constructor(
    private val storage: PokemonRepository
) {

    fun saveFavoritePokemon(pokemon: PokemonLocal): Boolean {
        return storage.save(pokemon)
    }
}