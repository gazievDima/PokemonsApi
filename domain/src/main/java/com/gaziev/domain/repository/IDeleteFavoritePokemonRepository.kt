package com.gaziev.domain.repository

import com.gaziev.domain.models.Pokemon

interface IDeleteFavoritePokemonRepository {
    fun delete(pokemon: Pokemon): Boolean
}