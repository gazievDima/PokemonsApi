package com.gaziev.data.models

import java.io.Serializable

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
    val images: ImagesRemoteEntity?

) : Serializable

class ImagesRemoteEntity(val small: String?, val large: String?)

class PokemonsRetrofitEntity(
    val data: List<PokemonRemoteEntity>?,
    val page: Int?,
    val pageSize: Int?,
    val count: Int?,
    val totalCount: Int?
)