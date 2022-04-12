package com.gaziev.domain.repository

import com.gaziev.domain.models.PokemonBD

interface ISaveFavoritePokemonRepository {
    fun save(pokemon: PokemonBD): Boolean
}