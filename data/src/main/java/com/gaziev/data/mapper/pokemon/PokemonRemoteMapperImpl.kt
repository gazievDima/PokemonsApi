package com.gaziev.data.mapper.pokemon

import com.gaziev.data.mapper.DefaultValues
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
            id = t.id ?: DefaultValues.STRING_NO_INFORMATION,
            name = t.name ?: DefaultValues.STRING_NO_INFORMATION,
            supertype = t.supertype ?: DefaultValues.STRING_NO_INFORMATION,
            hp = t.hp ?: DefaultValues.STRING_NO_INFORMATION,
            artist = t.artist ?: DefaultValues.STRING_NO_INFORMATION,
            images = mapper.mapTo(
                t.images ?: ImagesRemoteEntity(
                    DefaultValues.STRING_NO_IMAGE,
                    DefaultValues.STRING_NO_IMAGE
                )
            )
        )
    }

    override fun mapFrom(v: PokemonRemoteDetails): PokemonRemoteEntity {
        return PokemonRemoteEntity(
            id = v.id,
            name = v.name,
            supertype = v.supertype,
            hp = v.hp,
            artist = v.artist,
            images = mapper.mapFrom(
                v.images ?: ImagesRemoteDetails(
                    DefaultValues.STRING_NO_IMAGE,
                    DefaultValues.STRING_NO_IMAGE
                )
            )
        )
    }
}