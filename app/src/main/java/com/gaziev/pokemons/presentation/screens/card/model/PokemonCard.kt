package com.gaziev.pokemons.presentation.screens.card.model

import com.gaziev.domain.models.ImagesLocalDetails

class PokemonCard(
    var liked: Boolean,
    var primary_key: Int? = null,
    val id: String?,
    val name: String?,
    val supertype: String?,
    val subtypes: List<String>?,
    val hp: String?,
    val types: List<String>?,
    val evolvesTo: List<String>?,
    val rules: List<String>?,
    val artist: String?,
    val rarity: String?,
    val images: ImagesLocalDetails?
)