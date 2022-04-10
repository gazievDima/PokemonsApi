package com.gaziev.data.repository

import com.gaziev.data.mapper.FromData
import com.gaziev.data.repository.source.NetworkApi
import com.gaziev.pokemons.models.Pokemon
import com.gaziev.pokemons.repository.GetApiPokemons

class GetApiPokemonsRepository(
    private val storage: NetworkApi
) : GetApiPokemons {
    override fun get(): List<Pokemon> {
        return storage.getPokemons().map { FromData().mapTo(it) }
    }
}