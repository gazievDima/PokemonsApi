package com.gaziev.pokemons.ui.usecase

import com.gaziev.pokemons.core.models.common.Pokemon

interface GetFavoritePokemonsUseCase {
    fun getPokemons(): List<Pokemon>
}