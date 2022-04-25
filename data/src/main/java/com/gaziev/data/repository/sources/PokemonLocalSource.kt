package com.gaziev.data.repository.sources

import com.gaziev.data.models.PokemonLocalEntity

interface PokemonLocalSource {

     fun getCachePokemons(): List<PokemonLocalEntity> = TODO()
     fun getFavoritesPokemons(): List<PokemonLocalEntity> = TODO()
     fun deletePokemon(pokemon: PokemonLocalEntity): Boolean = TODO()
     fun savePokemon(pokemon: PokemonLocalEntity): Boolean = TODO()
}