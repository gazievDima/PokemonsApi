package com.gaziev.domain.repository

import com.gaziev.domain.models.Pokemon

interface IGetFavoritePokemonsRepository {
    fun get(): List<Pokemon>
}