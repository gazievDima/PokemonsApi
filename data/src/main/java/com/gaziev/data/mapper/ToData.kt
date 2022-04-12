package com.gaziev.data.mapper

import com.gaziev.data.models.PokemonApiDaoData
import com.gaziev.data.models.PokemonBDDaoData
import com.gaziev.domain.models.PokemonApi
import com.gaziev.domain.models.PokemonBD

class ToData {

    fun mapTo(t: PokemonBD): PokemonBDDaoData {
        return PokemonBDDaoData(
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

    fun mapTo(t: PokemonApi): PokemonApiDaoData {
        return PokemonApiDaoData(
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