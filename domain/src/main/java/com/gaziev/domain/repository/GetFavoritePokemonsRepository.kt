package com.gaziev.domain.repository

interface GetFavoritePokemonsRepository {
    fun get(): List<com.gaziev.domain.models.Pokemon>
}