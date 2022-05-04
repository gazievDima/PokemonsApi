package com.gaziev.data.mapper

import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.ImagesDetails
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import javax.inject.Inject

class PokemonRemoteLocalMapperImpl @Inject constructor() :
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
            images = t.images
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
            images = v.images
        )
    }
}