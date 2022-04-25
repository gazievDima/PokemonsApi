package com.gaziev.domain.usecases.sort

import com.gaziev.domain.comparator.PokemonComparator
import com.gaziev.domain.models.PokemonLocal
import java.util.*
import javax.inject.Inject

class SortedPokemonsByLatestUseCase @Inject constructor(
    private val pokemonComparatorLatestUp: PokemonComparator.LatestUp,
    private val pokemonComparatorLatestDown: PokemonComparator.LatestDown,
) {

    fun up(pokemons: List<PokemonLocal>): List<PokemonLocal> {
        Collections.sort(pokemons, pokemonComparatorLatestUp)
        return pokemons
    }

    fun down(pokemons: List<PokemonLocal>): List<PokemonLocal> {
        Collections.sort(pokemons, pokemonComparatorLatestDown)
        return pokemons
    }
}