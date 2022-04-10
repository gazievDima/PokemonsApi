package com.gaziev.data.repository

import com.gaziev.pokemons.models.Pokemon
import com.gaziev.pokemons.repository.SaveFavoritePokemon

class SaveFavoritePokemonRepository : SaveFavoritePokemon {
    override fun save(pokemon: Pokemon): Boolean {
        return true
    }
}