package com.gaziev.data.mapper

import com.gaziev.data.models.PokemonApi
import com.gaziev.domain.models.Pokemon

class FromData {

    fun mapTo(t: PokemonApi): Pokemon {
        return Pokemon(
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