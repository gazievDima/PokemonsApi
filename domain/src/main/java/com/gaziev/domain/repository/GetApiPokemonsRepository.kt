package com.gaziev.domain.repository

interface GetApiPokemonsRepository {
    fun get(): List<com.gaziev.domain.models.Pokemon>
}