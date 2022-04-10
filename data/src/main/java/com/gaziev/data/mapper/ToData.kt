package com.gaziev.data.mapper

import com.gaziev.data.models.PokemonData
import com.gaziev.pokemons.models.Pokemon

class ToData {

    fun map(t: Pokemon): PokemonData {
        return PokemonData(name = t.name)
    }
}