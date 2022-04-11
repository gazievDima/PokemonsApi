package com.gaziev.domain.repository

import com.gaziev.domain.models.PokemonBDDao

interface IDeleteFavoritePokemonRepository {
    fun delete(pokemon: PokemonBDDao): Boolean
}