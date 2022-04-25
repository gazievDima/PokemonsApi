package com.gaziev.pokemons.di

import com.gaziev.data.repository.sources.PokemonLocalSource
import com.gaziev.data.repository.sources.PokemonRemoteSource
import com.gaziev.data.sources.PokemonLocalSourceImpl
import com.gaziev.data.sources.PokemonRemoteSourceImpl
import dagger.Module
import dagger.Provides

@Module
class SourceModule {

    @Provides
    fun providePokemonLocalSource(): PokemonLocalSource {
        return PokemonLocalSourceImpl()
    }

    @Provides
    fun providePokemonRemoteSource(): PokemonRemoteSource {
        return PokemonRemoteSourceImpl()
    }
}