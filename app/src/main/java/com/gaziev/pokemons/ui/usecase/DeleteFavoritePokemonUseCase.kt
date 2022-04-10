package com.gaziev.pokemons.ui.usecase

import com.gaziev.pokemons.core.models.common.Pokemon

interface DeleteFavoritePokemonUseCase {
    fun deletePokemon(pokemon: Pokemon): Boolean
}