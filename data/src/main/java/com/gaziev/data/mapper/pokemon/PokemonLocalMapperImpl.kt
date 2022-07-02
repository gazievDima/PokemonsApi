package com.gaziev.data.mapper.pokemon

import com.gaziev.data.mapper.DefaultValues
import com.gaziev.data.models.ImagesLocalEntity
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.ImagesLocalDetails
import com.gaziev.domain.models.PokemonLocalDetails
import javax.inject.Inject

class PokemonLocalMapperImpl @Inject constructor(
    private val mapper: Mapper<ImagesLocalEntity, ImagesLocalDetails>
) :
    Mapper<PokemonLocalEntity, PokemonLocalDetails> {
    override fun mapTo(t: PokemonLocalEntity): PokemonLocalDetails {
        return PokemonLocalDetails(
            primary_key = t.primary_key,
            id = t.id ?: DefaultValues.STRING_NO_INFORMATION,
            name = t.name ?: DefaultValues.STRING_NO_INFORMATION,
            supertype = t.supertype ?: DefaultValues.STRING_NO_INFORMATION,
            hp = t.hp ?: DefaultValues.STRING_NO_INFORMATION,
            artist = t.artist ?: DefaultValues.STRING_NO_INFORMATION,
            images = mapper.mapTo(
                t.images ?: ImagesLocalEntity(
                    DefaultValues.STRING_NO_IMAGE,
                    DefaultValues.STRING_NO_IMAGE
                )
            )
        )
    }

    override fun mapFrom(v: PokemonLocalDetails): PokemonLocalEntity {
        return PokemonLocalEntity(
            primary_key = v.primary_key,
            id = v.id,
            name = v.name,
            supertype = v.supertype,
            hp = v.hp,
            artist = v.artist,
            images = mapper.mapFrom(
                v.images ?: ImagesLocalDetails(
                    DefaultValues.STRING_NO_IMAGE,
                    DefaultValues.STRING_NO_IMAGE
                )
            )
        )
    }
}