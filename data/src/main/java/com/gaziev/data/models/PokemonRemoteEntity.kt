package com.gaziev.data.models

import java.io.Serializable

class ImagesEntity(val small: String?, val large: String?)

class PokemonRemoteEntity(
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
    val images: ImagesEntity?

) : Serializable