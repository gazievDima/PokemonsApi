package com.gaziev.data.storage.api

import com.gaziev.data.models.PokemonData
import com.gaziev.data.repository.source.NetworkApi

class PokemonApiService : NetworkApi {
    override fun getPokemons(): List<PokemonData> {
        return listOf(
            PokemonData("Покемон 1"),
            PokemonData("Покемон 2"),
            PokemonData("Покемон 3"),
            PokemonData("Покемон 4"),
            PokemonData("Покемон 5"),
            PokemonData("Покемон 6"),
            PokemonData("Покемон 7"),
            PokemonData("Покемон 8"),
            PokemonData("Покемон 9"),
            PokemonData("Покемон 10"),
        )
    }

    override fun getPokemonsPage(pageNumber: Int, pageSize: Int): List<PokemonData> {
        return emptyList()
    }
}