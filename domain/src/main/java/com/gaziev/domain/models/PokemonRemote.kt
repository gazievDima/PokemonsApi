package com.gaziev.domain.models

import com.gaziev.domain.usecases.search.Compared
import java.io.Serializable

class PokemonRemote(
    val id: String,
    val name: String,
    val supertype: String,
    val hp: Int,
    val number: Int,
    val artist: String,
    val rarity: String,
    val flavorText: String
) : Serializable
