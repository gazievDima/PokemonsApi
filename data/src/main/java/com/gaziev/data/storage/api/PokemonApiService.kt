package com.gaziev.data.storage.api

import com.gaziev.data.models.PokemonApi
import com.gaziev.data.repository.source.INetworkApi

class PokemonApiService : INetworkApi {
    override fun getPokemons(): List<PokemonApi> {
        return emptyList()
    }

    override fun getPokemonsPage(pageNumber: Int, pageSize: Int): List<PokemonApi> {
        return emptyList()
    }
}