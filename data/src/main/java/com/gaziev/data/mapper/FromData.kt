package com.gaziev.data.mapper

class FromData {

    fun mapTo(t: PokemonApi): com.gaziev.domain.models.PokemonApiDao {
        return com.gaziev.domain.models.PokemonApiDao(
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