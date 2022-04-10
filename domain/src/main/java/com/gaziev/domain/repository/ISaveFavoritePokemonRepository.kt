package com.gaziev.domain.repository

import com.gaziev.domain.models.PokemonApiDao

interface ISaveFavoritePokemonRepository {
    fun save(pokemon: PokemonApiDao): Boolean
}