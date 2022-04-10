package com.gaziev.pokemons.core.mapper

import com.gaziev.pokemons.core.models.common.Pokemon
import com.gaziev.pokemons.core.models.data.PokemonData

class MapperToData {
    fun map(t: Pokemon) : PokemonData = PokemonData(t.name)
}