package com.gaziev.data.mapper.pokemon

import com.gaziev.data.models.ImagesRemoteEntity
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.ImagesRemoteDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import javax.inject.Inject

class PokemonRemoteMapperImpl @Inject constructor(
    private val mapper: Mapper<ImagesRemoteEntity, ImagesRemoteDetails>
) : Mapper<PokemonRemoteEntity, PokemonRemoteDetails> {

    override fun mapTo(t: PokemonRemoteEntity): PokemonRemoteDetails {
        return PokemonRemoteDetails(
            id = t.id,
            name = t.name,
            supertype = t.supertype,
            subtypes = t.subtypes,
            hp = t.hp,
            types = t.types,
            evolvesTo = t.evolvesTo,
            rules = t.rules,
            artist = t.artist,
            rarity = t.rarity,
            images = mapper.mapTo(t.images!!)
        )
    }

    override fun mapFrom(v: PokemonRemoteDetails): PokemonRemoteEntity {
        return PokemonRemoteEntity(
            id = v.id,
            name = v.name,
            supertype = v.supertype,
            subtypes = v.subtypes,
            hp = v.hp,
            types = v.types,
            evolvesTo = v.evolvesTo,
            rules = v.rules,
            artist = v.artist,
            rarity = v.rarity,
            images = mapper.mapFrom(v.images!!)
        )
    }
}