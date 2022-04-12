package com.gaziev.domain.repository

import com.gaziev.domain.models.PokemonBD

interface IGetFavoritePokemonsRepository {
    fun get(): List<PokemonBD>
}