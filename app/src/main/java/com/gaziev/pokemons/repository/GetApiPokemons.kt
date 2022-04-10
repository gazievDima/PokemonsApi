package com.gaziev.pokemons.repository

import com.gaziev.pokemons.models.Pokemon

interface GetApiPokemons {
    fun get(): List<Pokemon>
}