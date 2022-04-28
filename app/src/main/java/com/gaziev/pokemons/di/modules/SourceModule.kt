package com.gaziev.pokemons.di.modules

import com.gaziev.data.repository.sources.PokemonLocalSource
import com.gaziev.data.repository.sources.PokemonRemoteSource
import com.gaziev.data.sources.room.PokemonLocalSourceImpl
import com.gaziev.data.sources.retrofit.PokemonRemoteSourceImpl
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