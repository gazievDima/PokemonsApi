package com.gaziev.data.repository

import com.gaziev.data.mapper.IMapper
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.repository.sources.PokemonLocalSource
import com.gaziev.data.repository.sources.PokemonRemoteSource
import com.gaziev.domain.models.PokemonLocal
import com.gaziev.domain.models.PokemonRemote
import com.gaziev.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val localSource: PokemonLocalSource,
    private val remoteSource: PokemonRemoteSource,
    private val pokemonLocalMapper: IMapper<PokemonLocalEntity, PokemonLocal>,
    private val pokemonRemoteMapper: IMapper<PokemonRemoteEntity, PokemonRemote>
) : PokemonRepository {

    override fun getPokemons(): List<PokemonRemote> {
        return remoteSource.getPokemons().map { pokemonRemoteMapper.mapTo(it) }
    }

    override fun getFavoritesPokemons(): List<PokemonLocal> {
        return localSource.getFavoritesPokemons().map { pokemonLocalMapper.mapTo(it) }
    }

    override fun save(pokemon: PokemonLocal): Boolean {
        return localSource.savePokemon(pokemonLocalMapper.mapFrom(pokemon))
    }

    override fun delete(pokemon: PokemonLocal): Boolean {
        return localSource.deletePokemon(pokemonLocalMapper.mapFrom(pokemon))
    }

}