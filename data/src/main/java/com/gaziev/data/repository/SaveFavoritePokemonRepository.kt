package com.gaziev.data.repository

import com.gaziev.data.mapper.ToData
import com.gaziev.data.repository.source.LocalDataBase
import com.gaziev.pokemons.models.Pokemon
import com.gaziev.pokemons.repository.SaveFavoritePokemon

class SaveFavoritePokemonRepository(
    private val storage: LocalDataBase
) : SaveFavoritePokemon {
    override fun save(pokemon: Pokemon): Boolean {
        return storage.savePokemon(ToData().mapTo(pokemon))
    }
}