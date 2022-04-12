package com.gaziev.domain.usecases.get

import com.gaziev.domain.models.PokemonBD
import com.gaziev.domain.repository.IGetFavoritePokemonsRepository

class GetFavoritePokemonsUseCase(
    private val storage: IGetFavoritePokemonsRepository
) {

    fun get(): List<PokemonBD> = storage.get()
}