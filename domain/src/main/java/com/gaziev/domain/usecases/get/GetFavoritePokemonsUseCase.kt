package com.gaziev.domain.usecases.get

import com.gaziev.domain.models.Pokemon
import com.gaziev.domain.repository.GetFavoritePokemonsRepository

class GetFavoritePokemonsUseCase(
    private val storage: GetFavoritePokemonsRepository
) {

    fun get(): List<Pokemon> = storage.get()
}