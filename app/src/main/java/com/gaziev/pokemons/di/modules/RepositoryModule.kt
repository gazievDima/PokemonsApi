package com.gaziev.pokemons.di.modules

import com.gaziev.data.mapper.PokemonLocalMapper
import com.gaziev.data.mapper.PokemonRemoteMapper
import com.gaziev.data.repository.PokemonRepositoryImpl
import com.gaziev.data.sources.room.PokemonLocalSourceImpl
import com.gaziev.data.sources.retrofit.PokemonRemoteSourceImpl
import com.gaziev.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providePokemonRepository(
        localSource: PokemonLocalSourceImpl,
        remoteSource: PokemonRemoteSourceImpl,
        pokemonLocalMapper: PokemonLocalMapper,
        pokemonRemoteMapper: PokemonRemoteMapper
    ) : PokemonRepository {
        return PokemonRepositoryImpl(
            localSource,
            remoteSource,
            pokemonLocalMapper,
            pokemonRemoteMapper,
        )
    }
}