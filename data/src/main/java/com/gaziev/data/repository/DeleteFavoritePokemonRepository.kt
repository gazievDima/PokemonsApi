package com.gaziev.data.repository

import com.gaziev.data.mapper.ToData
import com.gaziev.data.repository.source.LocalDataBase
import com.gaziev.pokemons.models.Pokemon
import com.gaziev.pokemons.repository.DeleteFavoritePokemon

class DeleteFavoritePokemonRepository(
    private val storage: LocalDataBase
) : DeleteFavoritePokemon {
    override fun delete(pokemon: Pokemon): Boolean {
        return storage.deletePokemon(ToData().mapTo(pokemon))
    }
}