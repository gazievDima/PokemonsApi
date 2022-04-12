package com.gaziev.data.mapper

import com.gaziev.data.models.PokemonApiData
import com.gaziev.data.models.PokemonBDData
import com.gaziev.domain.models.PokemonApi
import com.gaziev.domain.models.PokemonBD

class FromData {

    fun mapTo(t: PokemonBDData): PokemonBD {
        return PokemonBD(
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

    fun mapTo(t: PokemonApiData): PokemonApi {
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