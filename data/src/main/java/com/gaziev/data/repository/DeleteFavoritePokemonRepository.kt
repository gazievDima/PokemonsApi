package com.gaziev.data.repository

import com.gaziev.data.mapper.ToData
import com.gaziev.data.repository.source.LocalDataBase
import com.gaziev.domain.models.Pokemon
import com.gaziev.domain.repository.DeleteFavoritePokemonRepository

class DeleteFavoritePokemonRepository(
    private val storage: LocalDataBase
) : DeleteFavoritePokemonRepository {
    override fun delete(pokemon: Pokemon): Boolean {
        return storage.deletePokemon(ToData().mapTo(pokemon))
    }
}