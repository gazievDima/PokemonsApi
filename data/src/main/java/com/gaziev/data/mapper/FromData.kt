package com.gaziev.data.mapper

import com.gaziev.data.models.PokemonData
import com.gaziev.pokemons.models.Pokemon

class FromData {

    fun mapTo(t: PokemonData): Pokemon {
        return Pokemon(name = t.name)
    }
}