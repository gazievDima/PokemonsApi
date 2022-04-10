package com.gaziev.data.mapper

import com.gaziev.data.models.PokemonApi
import com.gaziev.domain.models.Pokemon

class ToData {

    fun mapTo(t: Pokemon): PokemonApi {
        return PokemonApi(
            id = t.id,
            name = t.name,
            supertype = t.supertype,
            hp = t.hp,
            number = t.number,
            artist = t.artist,
            rarity = t.rarity,
            flavorText = t.flavorText
        )
    }
}