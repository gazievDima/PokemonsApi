package com.gaziev.pokemons.ui.usecase

import com.gaziev.pokemons.core.models.common.Pokemon

interface GetPokemonsUseCase {
    fun getPokemons(): List<Pokemon>
}