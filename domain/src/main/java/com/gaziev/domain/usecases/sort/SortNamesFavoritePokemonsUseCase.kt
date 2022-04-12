package com.gaziev.domain.usecases.sort

import com.gaziev.domain.comparator.PokemonBDDaoComparator
import com.gaziev.domain.models.PokemonBD
import java.util.*

class SortNamesFavoritePokemonsUseCase {

    fun up(pokemons: List<PokemonBD>): List<PokemonBD> {
        Collections.sort(pokemons, PokemonBDDaoComparator.NameUp())
        return pokemons
    }

    fun down(pokemons: List<PokemonBD>): List<PokemonBD> {
        Collections.sort(pokemons, PokemonBDDaoComparator.NameDown())
        return pokemons
    }
}