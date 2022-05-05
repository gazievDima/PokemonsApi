package com.gaziev.data.mapper.pokemon

import com.gaziev.data.models.ImagesLocalEntity
import com.gaziev.data.models.ImagesRemoteEntity
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.ImagesLocalDetails
import com.gaziev.domain.models.ImagesRemoteDetails
import com.gaziev.domain.models.PokemonLocalDetails
import javax.inject.Inject

class PokemonLocalMapperImpl @Inject constructor(
    private val mapper: Mapper<ImagesLocalEntity, ImagesLocalDetails>
) :
    Mapper<PokemonLocalEntity, PokemonLocalDetails> {
    override fun mapTo(t: PokemonLocalEntity): PokemonLocalDetails {
        return PokemonLocalDetails(
            primary_key = null,
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

    override fun mapFrom(v: PokemonLocalDetails): PokemonLocalEntity {
        return PokemonLocalEntity(
            primary_key = null,
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