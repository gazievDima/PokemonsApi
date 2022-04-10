package com.gaziev.data.storage.room

import com.gaziev.data.models.PokemonData
import com.gaziev.data.repository.source.LocalDataBase

class PokemonRoomDataBase : LocalDataBase {
    override fun deletePokemon(pokemon: PokemonData): Boolean {
        return true
    }

    override fun savePokemon(pokemon: PokemonData): Boolean {
        return true
    }

    override fun getPokemons(pokemon: PokemonData): List<PokemonData> {
        return emptyList()
    }


}