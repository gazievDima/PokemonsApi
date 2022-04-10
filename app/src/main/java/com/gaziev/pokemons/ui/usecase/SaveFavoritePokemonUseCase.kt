package com.gaziev.pokemons.ui.usecase

import com.gaziev.pokemons.core.models.common.Pokemon

interface SaveFavoritePokemonUseCase {
    fun savePokemon(pokemon: Pokemon): Boolean
}