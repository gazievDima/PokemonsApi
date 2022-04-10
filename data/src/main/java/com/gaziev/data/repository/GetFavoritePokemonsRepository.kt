package com.gaziev.data.repository

import com.gaziev.data.mapper.FromData
import com.gaziev.data.repository.source.LocalDataBase
import com.gaziev.domain.models.Pokemon
import com.gaziev.domain.repository.GetFavoritePokemonsRepository

class GetFavoritePokemonsRepository(
    private val storage: LocalDataBase
) : GetFavoritePokemonsRepository {
    override fun get(): List<Pokemon> {
        return storage.getPokemons().map { FromData().mapTo(it) }
    }
}