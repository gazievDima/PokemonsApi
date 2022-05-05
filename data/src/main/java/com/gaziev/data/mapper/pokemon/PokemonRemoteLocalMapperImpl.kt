package com.gaziev.data.mapper.pokemon

import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.ImagesLocalDetails
import com.gaziev.domain.models.ImagesRemoteDetails
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import javax.inject.Inject

class PokemonRemoteLocalMapperImpl @Inject constructor(
    private val mapper: Mapper<ImagesRemoteDetails, ImagesLocalDetails>
) :
    Mapper<PokemonRemoteDetails, PokemonLocalDetails> {

    override fun mapTo(t: PokemonRemoteDetails): PokemonLocalDetails {
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

    override fun mapFrom(v: PokemonLocalDetails): PokemonRemoteDetails {
        return PokemonRemoteDetails(
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