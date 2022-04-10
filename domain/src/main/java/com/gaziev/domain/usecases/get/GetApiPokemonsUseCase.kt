package com.gaziev.domain.usecases.get

import com.gaziev.domain.models.Pokemon
import com.gaziev.domain.repository.GetApiPokemonsRepository

class GetApiPokemonsUseCase(
    private val storage: GetApiPokemonsRepository
) {

    fun get(): List<Pokemon> = storage.get()
}