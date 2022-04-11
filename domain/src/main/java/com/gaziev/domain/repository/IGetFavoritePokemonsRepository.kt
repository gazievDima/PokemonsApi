package com.gaziev.domain.repository

import com.gaziev.domain.models.PokemonBDDao

interface IGetFavoritePokemonsRepository {
    fun get(): List<PokemonBDDao>
}