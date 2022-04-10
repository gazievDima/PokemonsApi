package com.gaziev.pokemons.core.mapper

import com.gaziev.pokemons.core.models.common.Pokemon
import com.gaziev.pokemons.core.models.data.PokemonData

class MapperFromData {
    fun map(t: PokemonData) : Pokemon = Pokemon(t.name)
}