package com.gaziev.pokemons.di.modules

import com.gaziev.data.repository.sources.PokemonLocalSource
import com.gaziev.data.repository.sources.PokemonRemoteSource
import com.gaziev.data.sources.room.PokemonLocalSourceImpl
import com.gaziev.data.sources.remote.PokemonRemoteSourceImpl
import com.gaziev.data.sources.remote.retrofit.PokemonsApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class SourceModule {

    @Provides
    fun providePokemonLocalSource(): PokemonLocalSource {
        return PokemonLocalSourceImpl()
    }

    @Provides
    fun providePokemonRemoteSource(
        pokemonsApiService: PokemonsApiService
    ): PokemonRemoteSource {
        return PokemonRemoteSourceImpl(pokemonsApiService)
    }
}