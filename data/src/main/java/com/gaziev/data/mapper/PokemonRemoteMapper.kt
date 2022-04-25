package com.gaziev.data.mapper

import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.domain.models.PokemonRemote
import javax.inject.Inject

class PokemonRemoteMapper @Inject constructor() : IMapper<PokemonRemoteEntity, PokemonRemote> {
    override fun mapTo(t: PokemonRemoteEntity): PokemonRemote {
        return PokemonRemote(
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

    override fun mapFrom(v: PokemonRemote): PokemonRemoteEntity {
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