package com.gaziev.domain.models

import java.io.Serializable

class PokemonApi(
    val id: String,
    val name: String,
    val supertype: String,
    val hp: Int,
    val number: Int,
    val artist: String,
    val rarity: String,
    val flavorText: String
) : Serializable
