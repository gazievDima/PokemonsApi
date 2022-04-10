package com.gaziev.domain.repository

import com.gaziev.domain.models.PokemonApiDao

interface IGetFavoritePokemonsRepository {
    fun get(): List<PokemonApiDao>
}