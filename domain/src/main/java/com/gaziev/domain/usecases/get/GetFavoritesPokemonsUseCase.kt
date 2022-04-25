package com.gaziev.domain.usecases.get

import com.gaziev.domain.models.PokemonLocal
import com.gaziev.domain.repository.PokemonRepository
import javax.inject.Inject

class GetFavoritesPokemonsUseCase @Inject constructor(
    private val storage: PokemonRepository
) {

    fun get(): List<PokemonLocal> = storage.getFavoritesPokemons()
}