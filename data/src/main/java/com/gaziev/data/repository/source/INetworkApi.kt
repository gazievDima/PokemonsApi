package com.gaziev.data.repository.source

import com.gaziev.data.models.PokemonApiData

interface INetworkApi {
    fun getPokemons(): List<PokemonApiData>
    fun getPokemonsPage(pageNumber: Int, pageSize: Int): List<PokemonApiData>
}