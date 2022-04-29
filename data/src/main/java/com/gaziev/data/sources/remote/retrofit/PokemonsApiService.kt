package com.gaziev.data.sources.remote.retrofit

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonsApiService {

        //list card pokemon (250 cards)
        @GET("v2/cards")
        suspend fun getPokemonsCard(): PokemonCards

        //get pokemons by page and pageSize query
        //https://api.pokemontcg.io/v2/cards?page=1&pageSize=1
        @GET("v2/cards")
        suspend fun getPagePokemonsCards(@Query("page") page: Int, @Query("pageSize") pageSize: Int): PokemonCards

}