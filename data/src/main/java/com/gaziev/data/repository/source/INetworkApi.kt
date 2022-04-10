package com.gaziev.data.repository.source

import com.gaziev.data.models.PokemonApi

interface INetworkApi {
    fun getPokemons(): List<PokemonApi>
    fun getPokemonsPage(pageNumber: Int, pageSize: Int): List<PokemonApi>
}