package com.gaziev.data.repository.source

import com.gaziev.data.models.PokemonData

interface NetworkApi {
    fun getPokemons(): List<PokemonData>
    fun getPokemonsPage(pageNumber: Int, pageSize: Int): List<PokemonData>
}