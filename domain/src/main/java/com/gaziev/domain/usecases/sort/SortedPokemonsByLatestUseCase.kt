package com.gaziev.domain.usecases.sort

import com.gaziev.domain.dispatcher.DispatcherCoroutine
import com.gaziev.domain.models.PokemonLocalDetails
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject
import kotlin.Comparator

class SortedPokemonsByLatestUseCase @Inject constructor(
    private val pokemonComparatorLatestUp: Comparator<PokemonLocalDetails>,
    private val pokemonComparatorLatestDown: Comparator<PokemonLocalDetails>,
    private val dispatcher: DispatcherCoroutine
) {

    suspend fun up(pokemons: List<PokemonLocalDetails>): List<PokemonLocalDetails> =
        withContext(dispatcher.get()) {
        Collections.sort(pokemons, pokemonComparatorLatestUp)
        return@withContext pokemons
    }

    suspend fun down(pokemons: List<PokemonLocalDetails>): List<PokemonLocalDetails> =
        withContext(dispatcher.get()) {
        Collections.sort(pokemons, pokemonComparatorLatestDown)
        return@withContext pokemons
    }
}