package com.gaziev.pokemons.presentation.screens.card.model

import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.ImagesLocalDetails
import com.gaziev.domain.models.ImagesRemoteDetails
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import javax.inject.Inject

interface PokemonMapper

class PokemonCardMapperImpl @Inject constructor(
    private val mapper: Mapper<ImagesRemoteDetails, ImagesLocalDetails>
) : PokemonMapper {

    fun mapRemoteToCard(t: PokemonRemoteDetails): PokemonCard {
        return PokemonCard(
            liked = false,
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

    fun mapLocalToCard(t: PokemonLocalDetails): PokemonCard {
        return PokemonCard(
            liked = true,
            primary_key = t.primary_key,
            id = t.id,
            name = t.name,
            supertype = t.supertype,
            hp = t.hp,
            artist = t.artist,
            images = t.images,
            subtypes = null,
            types = null,
            evolvesTo = null,
            rules = null,
            rarity = null
        )
    }

    fun mapCardToLocal(t: PokemonCard): PokemonLocalDetails {
        return PokemonLocalDetails(
            primary_key = t.primary_key,
            id = t.id,
            name = t.name,
            supertype = t.supertype,
            hp = t.hp,
            artist = t.artist,
            images = t.images
        )
    }
}