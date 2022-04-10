package com.gaziev.domain.usecases.get

import com.gaziev.domain.models.Pokemon
import com.gaziev.domain.repository.IGetFavoritePokemonsRepository

class GetFavoritePokemonsUseCase(
    private val storage: IGetFavoritePokemonsRepository
) {

    fun get(): List<Pokemon> = storage.get()
}