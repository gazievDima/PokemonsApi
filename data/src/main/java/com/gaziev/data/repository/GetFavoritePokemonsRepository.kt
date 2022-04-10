package com.gaziev.data.repository

import com.gaziev.data.mapper.FromData
import com.gaziev.data.repository.source.ILocalDataBase
import com.gaziev.domain.models.Pokemon
import com.gaziev.domain.repository.IGetFavoritePokemonsRepository

class GetFavoritePokemonsRepository(
    private val storage: ILocalDataBase
) : IGetFavoritePokemonsRepository {
    override fun get(): List<Pokemon> {
        return storage.getPokemons().map { FromData().mapTo(it) }
    }
}