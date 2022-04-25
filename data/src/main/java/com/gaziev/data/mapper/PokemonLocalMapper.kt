package com.gaziev.data.mapper

import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.domain.models.PokemonLocal
import javax.inject.Inject

class PokemonLocalMapper @Inject constructor() : IMapper<PokemonLocalEntity, PokemonLocal> {
    override fun mapTo(t: PokemonLocalEntity): PokemonLocal {
        return PokemonLocal(
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

    override fun mapFrom(v: PokemonLocal): PokemonLocalEntity {
        return PokemonLocalEntity(
            primary_key = v.primary_key,
            id = v.id,
            name = v.name,
            supertype = v.supertype,
            hp = v.hp,
            number = v.number,
            artist = v.artist,
            rarity = v.rarity,
            flavorText = v.flavorText
        )
    }
}