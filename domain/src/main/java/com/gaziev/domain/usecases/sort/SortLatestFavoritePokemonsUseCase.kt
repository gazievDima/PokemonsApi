package com.gaziev.domain.usecases.sort

import com.gaziev.domain.comparator.PokemonBDDaoComparator
import com.gaziev.domain.models.PokemonBD
import java.util.*

class SortLatestFavoritePokemonsUseCase {

    fun up(pokemons: List<PokemonBD>): List<PokemonBD> {
        Collections.sort(pokemons, PokemonBDDaoComparator.LatestUp())
        return pokemons
    }

    fun down(pokemons: List<PokemonBD>): List<PokemonBD> {
        Collections.sort(pokemons, PokemonBDDaoComparator.LatestDown())
        return pokemons
    }
}