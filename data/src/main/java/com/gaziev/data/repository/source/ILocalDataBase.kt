package com.gaziev.data.repository.source

<<<<<<< HEAD
import com.gaziev.data.models.PokemonBDData
=======
import com.gaziev.data.models.PokemonBDDaoData
>>>>>>> UI

interface ILocalDataBase {
    fun deletePokemon(pokemon: PokemonBDData): Boolean
    fun savePokemon(pokemon: PokemonBDData): Boolean
    fun getPokemons(): List<PokemonBDData>
}