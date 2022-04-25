package com.gaziev.data.repository.sources

import com.gaziev.data.models.PokemonRemoteEntity

interface PokemonRemoteSource {

    fun getPokemons(): List<PokemonRemoteEntity>
}