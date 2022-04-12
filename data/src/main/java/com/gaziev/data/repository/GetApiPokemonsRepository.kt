package com.gaziev.data.repository

import com.gaziev.data.mapper.FromData
import com.gaziev.data.repository.source.INetworkApi
import com.gaziev.domain.models.PokemonApi
import com.gaziev.domain.repository.IGetApiPokemonsRepository

class GetApiPokemonsRepository(
    private val storage: INetworkApi
) : IGetApiPokemonsRepository {

    override fun get(): List<PokemonApi> {
        return storage.getPokemons().map { FromData().mapTo(it) }
    }
}