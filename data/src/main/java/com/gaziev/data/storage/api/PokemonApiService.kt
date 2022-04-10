package com.gaziev.data.storage.api

import com.gaziev.data.models.PokemonData
import com.gaziev.data.repository.source.NetworkApi

class PokemonApiService : NetworkApi {
    override fun getPokemons(): List<PokemonData> {
        return emptyList()
    }

    override fun getPokemonsPage(pageNumber: Int, pageSize: Int): List<PokemonData> {
        return emptyList()
    }
}