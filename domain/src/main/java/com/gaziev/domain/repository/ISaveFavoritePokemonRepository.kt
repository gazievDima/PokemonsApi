package com.gaziev.domain.repository

import com.gaziev.domain.models.Pokemon

interface ISaveFavoritePokemonRepository {
    fun save(pokemon: Pokemon): Boolean
}