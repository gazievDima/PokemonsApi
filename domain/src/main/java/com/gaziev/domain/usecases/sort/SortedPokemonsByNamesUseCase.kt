package com.gaziev.domain.usecases.sort

import com.gaziev.domain.common.DispatcherDomain
import com.gaziev.domain.comparator.PokemonComparator
import com.gaziev.domain.models.PokemonLocalDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class SortedPokemonsByNamesUseCase @Inject constructor(
    private val pokemonComparatorNameUp: PokemonComparator.NameUp,
    private val pokemonComparatorNameDown: PokemonComparator.NameDown,
    private val dispatcher: DispatcherDomain
) {

    suspend fun up(pokemons: List<PokemonLocalDetails>): List<PokemonLocalDetails> = withContext(dispatcher.inject()) {
        Collections.sort(pokemons, pokemonComparatorNameUp)
        return@withContext pokemons
    }

    suspend fun down(pokemons: List<PokemonLocalDetails>): List<PokemonLocalDetails> = withContext(dispatcher.inject()) {
        Collections.sort(pokemons, pokemonComparatorNameDown)
        return@withContext pokemons
    }
}