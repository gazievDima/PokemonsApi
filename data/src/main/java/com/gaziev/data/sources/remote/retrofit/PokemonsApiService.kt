package com.gaziev.data.sources.remote.retrofit

import retrofit2.http.GET

interface PokemonsApiService {

        //list card pokemon (first 250 cards)
        @GET("v2/cards")
        suspend fun getPokemonsCard(): PokemonCards

}