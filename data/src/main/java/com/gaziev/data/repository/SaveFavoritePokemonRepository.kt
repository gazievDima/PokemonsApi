package com.gaziev.data.repository

import com.gaziev.data.mapper.ToData
import com.gaziev.data.repository.source.ILocalDataBase
import com.gaziev.domain.models.Pokemon
import com.gaziev.domain.repository.ISaveFavoritePokemonRepository

class SaveFavoritePokemonRepository(
    private val storage: ILocalDataBase
) : ISaveFavoritePokemonRepository {
    override fun save(pokemon: Pokemon): Boolean {
        return storage.savePokemon(ToData().mapTo(pokemon))
    }
}