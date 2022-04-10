package com.gaziev.data.mapper

import com.gaziev.data.models.PokemonData
import com.gaziev.domain.models.Pokemon

class ToData {

    fun mapTo(t: Pokemon): PokemonData {
        return PokemonData(name = t.name)
    }
}