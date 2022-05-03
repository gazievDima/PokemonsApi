package com.gaziev.pokemons.di.modules

import com.gaziev.data.mapper.PokemonLocalMapperImpl
import com.gaziev.data.repository.PokemonRepositoryImpl
import com.gaziev.data.sources.local.PokemonLocalSourceImpl
import com.gaziev.data.sources.remote.PokemonsPagingSourceImpl
import com.gaziev.domain.repository.PokemonRepository
import com.gaziev.pokemons.dispatcher.DispatcherDataImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providePokemonRepository(
        localSource: PokemonLocalSourceImpl,
        remoteSource: PokemonsPagingSourceImpl,
        pokemonLocalMapper: PokemonLocalMapperImpl,
        dispatcher: DispatcherDataImpl
    ) : PokemonRepository {
        return PokemonRepositoryImpl(
            localSource,
            remoteSource,
            pokemonLocalMapper,
            dispatcher
        )
    }

}