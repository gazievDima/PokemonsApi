package com.gaziev.domain.usecases.sort

import com.gaziev.domain.common.DispatcherDomain
import com.gaziev.domain.comparator.PokemonComparator
import com.gaziev.domain.models.PokemonLocalDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class SortedPokemonsByHealthUseCase @Inject constructor(
    private val pokemonComparatorHealthUp: PokemonComparator.HealthUP,
    private val pokemonComparatorHealthDown: PokemonComparator.HealthDown,
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