package com.gaziev.data.repository

import com.gaziev.pokemons.models.Pokemon
import com.gaziev.pokemons.repository.GetFavoritePokemons

class GetFavoritePokemonsRepository : GetFavoritePokemons {
    override fun get(): List<Pokemon> {
        return emptyList()
    }
}