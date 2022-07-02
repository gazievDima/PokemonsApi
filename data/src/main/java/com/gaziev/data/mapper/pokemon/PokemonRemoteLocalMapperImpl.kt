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
            hp = t.hp,
            artist = t.artist,
            images = mapper.mapTo(t.images!!)
            )
    }

    override fun mapFrom(v: PokemonLocalDetails): PokemonRemoteDetails {
        return PokemonRemoteDetails(
            id = v.id,
            name = v.name,
            supertype = v.supertype,
            hp = v.hp,
            artist = v.artist,
            images = mapper.mapFrom(v.images!!),
            subtypes = null,
            types = null,
            evolvesTo = null,
            rules = null,
            rarity = null
        )
    }
}