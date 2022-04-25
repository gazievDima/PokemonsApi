package com.gaziev.domain.usecases.delete

import com.gaziev.domain.models.PokemonLocal
import com.gaziev.domain.repository.PokemonRepository
import javax.inject.Inject

class DeleteFavoritePokemonUseCase @Inject constructor(
    private val storage: PokemonRepository
) {

    fun deleteFavoritePokemon(pokemon: PokemonLocal): Boolean {
       return storage.delete(pokemon)
    }
}