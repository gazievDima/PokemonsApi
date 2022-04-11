package com.gaziev.data.repository

import com.gaziev.data.mapper.FromData
import com.gaziev.data.repository.source.INetworkApi
import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.domain.repository.IGetApiPokemonsRepository

class GetApiPokemonsRepository(
    private val storage: INetworkApi
) : IGetApiPokemonsRepository {

    override fun get(): List<PokemonApiDao> {
        return storage.getPokemons().map { FromData().mapTo(it) }
    }
}