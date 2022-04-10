package com.gaziev.data.repository.source

import com.gaziev.data.models.PokemonApi

interface ILocalDataBase {
    fun deletePokemon(pokemon: PokemonApi): Boolean
    fun savePokemon(pokemon: PokemonApi): Boolean
    fun getPokemons(): List<PokemonApi>
}