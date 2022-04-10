package com.gaziev.domain.repository

interface DeleteFavoritePokemonRepository {
    fun delete(pokemon: com.gaziev.domain.models.Pokemon): Boolean
}