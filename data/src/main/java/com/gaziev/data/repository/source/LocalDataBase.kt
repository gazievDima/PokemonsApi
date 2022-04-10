package com.gaziev.data.repository.source

import com.gaziev.data.models.PokemonData

interface LocalDataBase {
    fun deletePokemon(pokemon: PokemonData): Boolean
    fun savePokemon(pokemon: PokemonData): Boolean
    fun getPokemons(): List<PokemonData>
}