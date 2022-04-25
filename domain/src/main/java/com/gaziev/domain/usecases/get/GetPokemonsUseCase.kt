package com.gaziev.domain.usecases.get

import com.gaziev.domain.models.PokemonRemote
import com.gaziev.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val storage: PokemonRepository
) {

    fun get(): List<PokemonRemote> = storage.getPokemons()
}