package com.gaziev.data.storage.room

import com.gaziev.data.models.PokemonApi
import com.gaziev.data.repository.source.ILocalDataBase

class PokemonRoomDataBase : ILocalDataBase {
    override fun deletePokemon(pokemon: PokemonApi): Boolean {
        return true
    }

    override fun savePokemon(pokemon: PokemonApi): Boolean {
        return true
    }

    override fun getPokemons(): List<PokemonApi> {
        return emptyList()
    }

}