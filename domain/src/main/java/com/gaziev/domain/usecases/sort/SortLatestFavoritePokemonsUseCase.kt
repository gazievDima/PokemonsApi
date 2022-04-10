package com.gaziev.domain.usecases.sort

import com.gaziev.domain.comparator.PokemonBDDaoComparator
import com.gaziev.domain.models.PokemonBDDao
import java.util.*

class SortLatestFavoritePokemonsUseCase {

    fun up(pokemons: List<PokemonBDDao>): List<PokemonBDDao> {
        Collections.sort(pokemons, PokemonBDDaoComparator.LatestUp())
        return pokemons
    }

    fun down(pokemons: List<PokemonBDDao>): List<PokemonBDDao> {
        Collections.sort(pokemons, PokemonBDDaoComparator.LatestDown())
        return pokemons
    }
}