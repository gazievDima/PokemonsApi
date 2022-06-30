package com.gaziev.domain.usecases.sort

import com.gaziev.domain.dispatcher.DispatcherCoroutine
import com.gaziev.domain.models.PokemonLocalDetails
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject
import kotlin.Comparator

class SortedPokemonsByNamesUseCase @Inject constructor(
    private val pokemonComparatorNameUp: Comparator<PokemonLocalDetails>,
    private val pokemonComparatorNameDown: Comparator<PokemonLocalDetails>,
    private val dispatcher: DispatcherCoroutine
) {

    suspend fun up(pokemons: List<PokemonLocalDetails>): List<PokemonLocalDetails> = withContext(dispatcher.get()) {
        Collections.sort(pokemons, pokemonComparatorNameUp)
        return@withContext pokemons
    }

    suspend fun down(pokemons: List<PokemonLocalDetails>): List<PokemonLocalDetails> = withContext(dispatcher.get()) {
        Collections.sort(pokemons, pokemonComparatorNameDown)
        return@withContext pokemons
    }
}