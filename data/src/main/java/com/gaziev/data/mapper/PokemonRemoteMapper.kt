package com.gaziev.data.mapper

import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.domain.models.PokemonRemoteDetails
import javax.inject.Inject

class PokemonRemoteMapper @Inject constructor() : IMapper<PokemonRemoteEntity, PokemonRemoteDetails> {
    override fun mapTo(t: PokemonRemoteEntity): PokemonRemoteDetails {
        return PokemonRemoteDetails(
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

    override fun mapFrom(v: PokemonRemoteDetails): PokemonRemoteEntity {
        return PokemonRemoteEntity(
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