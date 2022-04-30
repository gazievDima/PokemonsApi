package com.gaziev.pokemons.di.modules

import com.gaziev.data.mapper.PokemonLocalMapperImpl
import com.gaziev.data.mapper.PokemonRemoteMapperImpl
import com.gaziev.data.repository.PokemonRepositoryImpl
import com.gaziev.data.sources.local.PokemonLocalSourceImpl
import com.gaziev.data.sources.remote.PokemonRemoteSourceImpl
import com.gaziev.domain.repository.PokemonRepository
import com.gaziev.pokemons.dispatcher.DispatcherDataImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providePokemonRepository(
        localSource: PokemonLocalSourceImpl,
        remoteSource: PokemonRemoteSourceImpl,
        pokemonLocalMapper: PokemonLocalMapperImpl,
        pokemonRemoteMapper: PokemonRemoteMapperImpl,
        dispatcher: DispatcherDataImpl
    ) : PokemonRepository {
        return PokemonRepositoryImpl(
            localSource,
            remoteSource,
            pokemonLocalMapper,
            pokemonRemoteMapper,
            dispatcher
        )
    }

}