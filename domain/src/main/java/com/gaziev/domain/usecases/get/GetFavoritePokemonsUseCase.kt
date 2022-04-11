package com.gaziev.domain.usecases.get

import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.domain.models.PokemonBDDao
import com.gaziev.domain.repository.IGetFavoritePokemonsRepository

class GetFavoritePokemonsUseCase(
    private val storage: IGetFavoritePokemonsRepository
) {

    fun get(): List<PokemonBDDao> = storage.get()
}