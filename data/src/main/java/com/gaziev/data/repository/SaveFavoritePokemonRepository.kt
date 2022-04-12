package com.gaziev.data.repository

import com.gaziev.data.mapper.ToData
import com.gaziev.data.repository.source.ILocalDataBase
import com.gaziev.domain.models.PokemonBD
import com.gaziev.domain.repository.ISaveFavoritePokemonRepository

class SaveFavoritePokemonRepository(
    private val storage: ILocalDataBase
) : ISaveFavoritePokemonRepository {

    override fun save(pokemon: PokemonBD): Boolean {
        return storage.savePokemon(ToData().mapTo(pokemon))
    }
}