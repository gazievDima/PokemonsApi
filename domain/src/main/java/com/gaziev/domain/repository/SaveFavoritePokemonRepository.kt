package com.gaziev.domain.repository

interface SaveFavoritePokemonRepository {
    fun save(pokemon: com.gaziev.domain.models.Pokemon): Boolean
}