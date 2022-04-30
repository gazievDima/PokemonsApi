package com.gaziev.data.sources.remote.retrofit

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface PokemonsApiService {

        @Headers("X-Api-Key: 0c5f87d2-75d5-4203-8364-f3a2b1821bcc")
        @GET("v2/cards")
        suspend fun getPokemonsCards(): PokemonsRetrofitEntity

        @Headers("X-Api-Key: 0c5f87d2-75d5-4203-8364-f3a2b1821bcc")
        @GET("v2/cards")
        suspend fun getPagePokemonsCards(@Query("page") page: Int, @Query("pageSize") pageSize: Int): PokemonsRetrofitEntity

}