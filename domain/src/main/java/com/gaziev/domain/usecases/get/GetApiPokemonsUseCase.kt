package com.gaziev.domain.usecases.get

import com.gaziev.domain.models.PokemonApi
import com.gaziev.domain.repository.IGetApiPokemonsRepository

class GetApiPokemonsUseCase(
    private val storage: IGetApiPokemonsRepository
) {

    fun get(): List<PokemonApi> = storage.get()
}