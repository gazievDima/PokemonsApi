package com.gaziev.domain.repository

import com.gaziev.domain.models.PokemonBDDao

interface ISaveFavoritePokemonRepository {
    fun save(pokemon: PokemonBDDao): Boolean
}