package com.gaziev.data.repository.source

import com.gaziev.data.models.PokemonBDData

interface ILocalDataBase {
    fun deletePokemon(pokemon: PokemonBDData): Boolean
    fun savePokemon(pokemon: PokemonBDData): Boolean
    fun getPokemons(): List<PokemonBDData>
}