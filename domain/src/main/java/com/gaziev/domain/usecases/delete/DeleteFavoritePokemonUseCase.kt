package com.gaziev.domain.usecases.delete

import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.domain.models.PokemonBDDao
import com.gaziev.domain.repository.IDeleteFavoritePokemonRepository

class DeleteFavoritePokemonUseCase(
    private val storage: IDeleteFavoritePokemonRepository
) {

    fun deleteFavoritePokemon(pokemon: PokemonBDDao): Boolean {
       return storage.delete(pokemon)
    }
}