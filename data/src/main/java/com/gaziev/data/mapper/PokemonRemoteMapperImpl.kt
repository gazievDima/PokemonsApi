package com.gaziev.data.mapper

import com.gaziev.data.models.ImagesEntity
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.repository.mapper.Mapper
import com.gaziev.domain.models.ImagesDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import javax.inject.Inject

class PokemonRemoteMapperImpl @Inject constructor(
    private val imageRemoteMapper: Mapper<ImagesEntity, ImagesDetails>
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
            images = imageRemoteMapper.mapTo(t.images!!)
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
            images = imageRemoteMapper.mapFrom(v.images!!)
        )
    }
}