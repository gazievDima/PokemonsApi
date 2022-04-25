package com.gaziev.domain.usecases.sort

import com.gaziev.domain.comparator.PokemonComparator
import com.gaziev.domain.models.PokemonLocal
import java.util.*
import javax.inject.Inject

class SortedPokemonsByNamesUseCase @Inject constructor(
    private val pokemonComparatorNameUp: PokemonComparator.NameUp,
    private val pokemonComparatorNameDown: PokemonComparator.NameDown
) {

    fun up(pokemons: List<PokemonLocal>): List<PokemonLocal> {
        Collections.sort(pokemons, pokemonComparatorNameUp)
        return pokemons
    }

    fun down(pokemons: List<PokemonLocal>): List<PokemonLocal> {
        Collections.sort(pokemons, pokemonComparatorNameDown)
        return pokemons
    }
}