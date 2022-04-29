package com.gaziev.pokemons.di.modules

import com.gaziev.data.sources.remote.PokemonRemoteSourceImpl
import com.gaziev.data.sources.remote.retrofit.PokemonsApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ServicesModule {

    @Singleton
    @Provides
    fun pokemonsApiService(): PokemonsApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.pokemontcg.io/")
            .build()
            .create(PokemonsApiService::class.java)
    }
}