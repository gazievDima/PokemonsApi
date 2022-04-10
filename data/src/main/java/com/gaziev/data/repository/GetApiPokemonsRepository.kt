package com.gaziev.data.repository

import com.gaziev.pokemons.models.Pokemon
import com.gaziev.pokemons.repository.GetApiPokemons

class GetApiPokemonsRepository : GetApiPokemons {
    override fun get(): List<Pokemon> {
        return emptyList()
    }
}