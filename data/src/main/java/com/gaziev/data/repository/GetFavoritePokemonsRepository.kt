package com.gaziev.data.repository

import com.gaziev.data.mapper.FromData
import com.gaziev.data.repository.source.LocalDataBase
import com.gaziev.pokemons.models.Pokemon
import com.gaziev.pokemons.repository.GetFavoritePokemons

class GetFavoritePokemonsRepository(
    private val storage: LocalDataBase
) : GetFavoritePokemons {
    override fun get(): List<Pokemon> {
        return storage.getPokemons().map { FromData().mapTo(it) }
    }
}