package com.gaziev.data.models

import java.io.Serializable

class PokemonRemoteEntity(
    val id: String?,
    val name: String?,
    val supertype: String?,
    val hp: String?,
    val artist: String?,
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