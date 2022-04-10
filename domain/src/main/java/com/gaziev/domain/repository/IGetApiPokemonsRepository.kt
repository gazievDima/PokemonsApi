package com.gaziev.domain.repository

import com.gaziev.domain.models.PokemonApiDao

interface IGetApiPokemonsRepository {
    fun get(): List<PokemonApiDao>
}