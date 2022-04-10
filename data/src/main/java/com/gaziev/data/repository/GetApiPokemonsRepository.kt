package com.gaziev.data.repository

import com.gaziev.data.mapper.FromData
import com.gaziev.data.repository.source.NetworkApi
import com.gaziev.domain.models.Pokemon
import com.gaziev.domain.repository.GetApiPokemonsRepository

class GetApiPokemonsRepository(
    private val storage: NetworkApi
) : GetApiPokemonsRepository {
    override fun get(): List<Pokemon> {
        return storage.getPokemons().map { FromData().mapTo(it) }
    }
}