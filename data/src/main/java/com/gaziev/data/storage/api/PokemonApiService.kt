package com.gaziev.data.storage.api

import com.gaziev.data.models.PokemonApi
import com.gaziev.data.repository.source.INetworkApi

class PokemonApiService : INetworkApi {
    override fun getPokemons(): List<PokemonApi> {
        return listOf(
            PokemonApi("Покемон 1"),
            PokemonApi("Покемон 2"),
            PokemonApi("Покемон 3"),
            PokemonApi("Покемон 4"),
            PokemonApi("Покемон 5"),
            PokemonApi("Покемон 6"),
            PokemonApi("Покемон 7"),
            PokemonApi("Покемон 8"),
            PokemonApi("Покемон 9"),
            PokemonApi("Покемон 10"),
        )
    }

    override fun getPokemonsPage(pageNumber: Int, pageSize: Int): List<PokemonApi> {
        return emptyList()
    }
}