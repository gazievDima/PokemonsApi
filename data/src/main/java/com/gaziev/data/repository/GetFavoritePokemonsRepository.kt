package com.gaziev.data.repository

import com.gaziev.data.mapper.FromData
import com.gaziev.data.mapper.ToData
import com.gaziev.data.repository.source.ILocalDataBase
import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.domain.models.PokemonBDDao
import com.gaziev.domain.repository.IGetFavoritePokemonsRepository

class GetFavoritePokemonsRepository(
    private val storage: ILocalDataBase
) : IGetFavoritePokemonsRepository {

    override fun get(): List<PokemonBDDao> {
        return storage.getPokemons().map { FromData().mapTo(it) }
    }
}