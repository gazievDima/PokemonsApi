package com.gaziev.data.repository.source

import com.gaziev.data.models.PokemonApiDaoData
import com.gaziev.data.models.PokemonBDDaoData

interface ILocalDataBase {
    fun deletePokemon(pokemon: PokemonBDDaoData): Boolean
    fun savePokemon(pokemon: PokemonBDDaoData): Boolean
    fun getPokemons(): List<PokemonBDDaoData>
}