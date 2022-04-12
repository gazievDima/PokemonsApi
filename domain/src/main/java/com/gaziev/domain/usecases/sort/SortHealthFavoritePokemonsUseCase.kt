package com.gaziev.domain.usecases.sort

import com.gaziev.domain.comparator.PokemonBDDaoComparator
import com.gaziev.domain.models.PokemonBD
import java.util.*

class SortHealthFavoritePokemonsUseCase {

    fun up(pokemons: List<PokemonBD>): List<PokemonBD> {
        Collections.sort(pokemons, PokemonBDDaoComparator.HealthUP())
        return pokemons
    }

    fun down(pokemons: List<PokemonBD>): List<PokemonBD> {
        Collections.sort(pokemons, PokemonBDDaoComparator.HealthDown())
        return pokemons
    }
}