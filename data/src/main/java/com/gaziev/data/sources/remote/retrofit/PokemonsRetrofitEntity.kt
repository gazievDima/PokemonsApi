package com.gaziev.data.sources.remote.retrofit

import com.gaziev.data.models.PokemonRemoteEntity

class PokemonsRetrofitEntity(
    val data: List<PokemonRemoteEntity>?,
    val page: Int?,
    val pageSize: Int?,
    val count: Int?,
    val totalCount: Int?
)