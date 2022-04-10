package com.gaziev.pokemons.repository

import com.gaziev.pokemons.models.Pokemon

interface DeleteFavoritePokemon {
    fun delete(pokemon: Pokemon): Boolean
}