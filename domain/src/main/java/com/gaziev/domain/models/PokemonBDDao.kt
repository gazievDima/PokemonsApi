package com.gaziev.domain.models

class PokemonBDDao(
    val primary_key: Int,
    val id: String,
    val name: String,
    val supertype: String,
    val hp: Int,
    val number: Int,
    val artist: String,
    val rarity: String,
    val flavorText: String
)