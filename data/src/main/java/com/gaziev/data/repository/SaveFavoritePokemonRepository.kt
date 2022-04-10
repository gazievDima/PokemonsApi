package com.gaziev.data.repository

import com.gaziev.data.mapper.ToData
import com.gaziev.data.repository.source.LocalDataBase
import com.gaziev.domain.models.Pokemon
import com.gaziev.domain.repository.SaveFavoritePokemonRepository

class SaveFavoritePokemonRepository(
    private val storage: LocalDataBase
) : SaveFavoritePokemonRepository {
    override fun save(pokemon: Pokemon): Boolean {
        return storage.savePokemon(ToData().mapTo(pokemon))
    }
}