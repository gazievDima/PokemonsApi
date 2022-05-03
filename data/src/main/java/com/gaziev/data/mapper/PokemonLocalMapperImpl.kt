package com.gaziev.data.mapper

import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.PokemonLocalDetails
import javax.inject.Inject

class PokemonLocalMapperImpl @Inject constructor() :
    Mapper<PokemonLocalEntity, PokemonLocalDetails> {
    override fun mapTo(t: PokemonLocalEntity): PokemonLocalDetails {
        return PokemonLocalDetails(
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

    override fun mapFrom(v: PokemonLocalDetails): PokemonLocalEntity {
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