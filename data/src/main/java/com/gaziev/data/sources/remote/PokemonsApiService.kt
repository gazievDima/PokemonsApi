package com.gaziev.data.sources.remote

import com.gaziev.data.models.PokemonsRetrofitEntity
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PokemonsApiService {

        @GET("v2/cards")
        suspend fun getPokemonsCards(
                @Header("X-Api-Key") api: String
        ): PokemonsRetrofitEntity

        @GET("v2/cards")
        suspend fun getPagePokemonsCards(
                @Header("X-Api-Key") api: String,
                @Query("page") page: Int,
                @Query("pageSize") pageSize: Int
        ): PokemonsRetrofitEntity
}