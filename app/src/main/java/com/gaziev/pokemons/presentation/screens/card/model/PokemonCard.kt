package com.gaziev.pokemons.presentation.screens.card.model

import com.gaziev.domain.models.ImagesLocalDetails

class PokemonCard(
    var liked: Boolean,
    var primary_key: Int? = null,
    val id: String,
    val name: String,
    val supertype: String,
    val hp: String,
    val artist: String,
    val images: ImagesLocalDetails?
)