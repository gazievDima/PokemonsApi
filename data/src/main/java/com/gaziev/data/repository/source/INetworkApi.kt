package com.gaziev.data.repository.source

import com.gaziev.data.models.PokemonApiDaoData

interface INetworkApi {
    fun getPokemons(): List<PokemonApiDaoData>
    fun getPokemonsPage(pageNumber: Int, pageSize: Int): List<PokemonApiDaoData>
}