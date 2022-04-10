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
        return listOf(
            PokemonApi("Покемон 1"),
            PokemonApi("Покемон 2"),
            PokemonApi("Покемон 3"),
            PokemonApi("Покемон 4"),
            PokemonApi("Покемон 5"),
            PokemonApi("Покемон 6"),
            PokemonApi("Покемон 7"),
            PokemonApi("Покемон 8"),
            PokemonApi("Покемон 9"),
            PokemonApi("Покемон 10"),
        )
    }

}