package com.gaziev.data.mapper

import com.gaziev.data.models.PokemonApiData
import com.gaziev.data.models.PokemonBDData
import com.gaziev.domain.models.PokemonApi
import com.gaziev.domain.models.PokemonBD

class ToData {

    fun mapTo(t: PokemonBD): PokemonBDData {
        return PokemonBDData(
            primary_key = t.primary_key,
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

    fun mapTo(t: PokemonApi): PokemonApiData {
        return PokemonApiData(
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