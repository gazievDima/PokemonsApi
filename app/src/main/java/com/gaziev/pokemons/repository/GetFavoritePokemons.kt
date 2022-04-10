package com.gaziev.pokemons.repository

import com.gaziev.pokemons.models.Pokemon

interface GetFavoritePokemons {
    fun get(): List<Pokemon>
}