package com.gaziev.domain.repository

import com.gaziev.domain.models.PokemonApiDao

interface IDeleteFavoritePokemonRepository {
    fun delete(pokemon: PokemonApiDao): Boolean
}