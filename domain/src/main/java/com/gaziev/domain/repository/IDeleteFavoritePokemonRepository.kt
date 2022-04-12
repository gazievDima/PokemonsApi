package com.gaziev.domain.repository

import com.gaziev.domain.models.PokemonBD

interface IDeleteFavoritePokemonRepository {
    fun delete(pokemon: PokemonBD): Boolean
}