package com.gaziev.domain.repository

import com.gaziev.domain.models.PokemonApi

interface IGetApiPokemonsRepository {
    fun get(): List<PokemonApi>
}