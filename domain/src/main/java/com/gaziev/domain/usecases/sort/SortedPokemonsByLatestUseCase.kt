package com.gaziev.domain.usecases.sort

import com.gaziev.domain.common.DispatcherDomain
import com.gaziev.domain.comparator.PokemonComparator
import com.gaziev.domain.models.PokemonLocalDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class SortedPokemonsByLatestUseCase @Inject constructor(
    private val pokemonComparatorLatestUp: PokemonComparator.LatestUp,
    private val pokemonComparatorLatestDown: PokemonComparator.LatestDown,
    private val dispatcher: DispatcherDomain
) {

    suspend fun up(pokemons: List<PokemonLocalDetails>): List<PokemonLocalDetails> =
        withContext(dispatcher.inject()) {
        Collections.sort(pokemons, pokemonComparatorLatestUp)
        return@withContext pokemons
    }

    suspend fun down(pokemons: List<PokemonLocalDetails>): List<PokemonLocalDetails> =
        withContext(dispatcher.inject()) {
        Collections.sort(pokemons, pokemonComparatorLatestDown)
        return@withContext pokemons
    }
}