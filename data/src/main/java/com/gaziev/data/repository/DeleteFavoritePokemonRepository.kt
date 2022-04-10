package com.gaziev.data.repository

import com.gaziev.data.mapper.ToData
import com.gaziev.data.repository.source.ILocalDataBase
import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.domain.repository.IDeleteFavoritePokemonRepository

class DeleteFavoritePokemonRepository(
    private val storage: ILocalDataBase
) : IDeleteFavoritePokemonRepository {
    override fun delete(pokemon: PokemonApiDao): Boolean {
        return storage.deletePokemon(ToData().mapTo(pokemon))
    }
}