package com.gaziev.data.repository

import com.gaziev.pokemons.models.Pokemon
import com.gaziev.pokemons.repository.DeleteFavoritePokemon

class DeleteFavoritePokemonRepository : DeleteFavoritePokemon {
    override fun delete(pokemon: Pokemon): Boolean {
        return true
    }
}