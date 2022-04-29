package com.gaziev.domain.models

import com.gaziev.domain.usecases.search.Compared
import java.io.Serializable

class PokemonRemoteDetails(
    val id: String?,
    val name: String?,
    val supertype: String?,
    val hp: String?,
    val number: String?,
    val artist: String?,
    val rarity: String?,
    val flavorText: String?
) : Serializable
