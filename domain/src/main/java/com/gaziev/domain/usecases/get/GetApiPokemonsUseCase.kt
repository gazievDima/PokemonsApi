package com.gaziev.domain.usecases.get

import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.domain.repository.IGetApiPokemonsRepository

class GetApiPokemonsUseCase(
    private val storage: IGetApiPokemonsRepository
) {

    fun get(): List<PokemonApiDao> = storage.get()
}