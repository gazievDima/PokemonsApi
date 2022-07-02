package com.gaziev.domain.models

import java.io.Serializable

class ImagesRemoteDetails(val small: String?, val large: String?)

class PokemonRemoteDetails(
    val id: String,
    val name: String,
    val supertype: String,
    val hp: String,
    val artist: String,
    val images: ImagesRemoteDetails?

) : Serializable

