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

    override fun getPokemons(): List<PokemonData> {
        return listOf(
            PokemonData("Покемон 1"),
            PokemonData("Покемон 2"),
            PokemonData("Покемон 3"),
            PokemonData("Покемон 4"),
            PokemonData("Покемон 5"),
            PokemonData("Покемон 6"),
            PokemonData("Покемон 7"),
            PokemonData("Покемон 8"),
            PokemonData("Покемон 9"),
            PokemonData("Покемон 10"),
        )
    }

}