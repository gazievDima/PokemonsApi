package com.gaziev.domain.repository

import com.gaziev.domain.models.Pokemon

interface IGetApiPokemonsRepository {
    fun get(): List<Pokemon>
}