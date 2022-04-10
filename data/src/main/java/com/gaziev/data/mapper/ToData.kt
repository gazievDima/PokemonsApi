package com.gaziev.data.mapper

class ToData {

    fun mapTo(t: com.gaziev.domain.models.PokemonApiDao): PokemonApi {
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