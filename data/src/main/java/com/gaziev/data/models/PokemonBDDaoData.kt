package com.gaziev.data.models

class PokemonBDDaoData(
    val primary_key: Int,
    val id: String,
    val name: String,
    val supertype: String,
    val hp: Int,
    val number: Int,
    val artist: String,
    val rarity: String,
    val flavorText: String
) {
}