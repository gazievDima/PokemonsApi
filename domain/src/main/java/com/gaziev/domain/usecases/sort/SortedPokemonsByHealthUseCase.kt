package com.gaziev.domain.usecases.sort

import com.gaziev.domain.usecases.DispatcherDomain
import com.gaziev.domain.models.PokemonLocalDetails
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject
import kotlin.Comparator

class SortedPokemonsByHealthUseCase @Inject constructor(
    private val pokemonComparatorHealthUp: Comparator<PokemonLocalDetails>,
    private val pokemonComparatorHealthDown: Comparator<PokemonLocalDetails>,
    private val dispatcher: DispatcherDomain
) {

    suspend fun up(pokemons: List<PokemonLocalDetails>): List<PokemonLocalDetails> =
        withContext(dispatcher.inject()) {
        Collections.sort(pokemons, pokemonComparatorHealthUp)
        return@withContext pokemons
    }

    suspend fun down(pokemons: List<PokemonLocalDetails>): List<PokemonLocalDetails> =
        withContext(dispatcher.inject()) {
            Collections.sort(pokemons, pokemonComparatorHealthDown)
            return@withContext pokemons
        }
}