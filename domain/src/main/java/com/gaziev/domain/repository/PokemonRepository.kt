package com.gaziev.domain.repository

import com.gaziev.domain.models.PokemonLocal
import com.gaziev.domain.models.PokemonRemote

interface PokemonRepository {
    fun getPokemons(): List<PokemonRemote>
    fun getFavoritesPokemons(): List<PokemonLocal>
    fun delete(pokemon: PokemonLocal): Boolean
    fun save(pokemon: PokemonLocal): Boolean

}