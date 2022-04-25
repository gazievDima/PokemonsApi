package com.gaziev.domain.usecases.sort

import com.gaziev.domain.comparator.PokemonComparator
import com.gaziev.domain.models.PokemonLocal
import java.util.*
import javax.inject.Inject

class SortedPokemonsByHealthUseCase @Inject constructor(
    private val pokemonComparatorHealthUp: PokemonComparator.HealthUP,
    private val pokemonComparatorHealthDown: PokemonComparator.HealthDown
) {

    fun up(pokemons: List<PokemonLocal>): List<PokemonLocal> {
        Collections.sort(pokemons, pokemonComparatorHealthUp)
        return pokemons
    }

    fun down(pokemons: List<PokemonLocal>): List<PokemonLocal> {
        Collections.sort(pokemons, pokemonComparatorHealthDown)
        return pokemons
    }
}