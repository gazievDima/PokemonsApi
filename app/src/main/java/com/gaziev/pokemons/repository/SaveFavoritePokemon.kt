package com.gaziev.pokemons.repository

import com.gaziev.pokemons.models.Pokemon

interface SaveFavoritePokemon {
    fun save(pokemon: Pokemon): Boolean
}