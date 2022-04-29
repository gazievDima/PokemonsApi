package com.gaziev.pokemons.di.modules

import com.gaziev.data.sources.remote.PokemonRemoteSourceImpl
import com.gaziev.data.sources.remote.retrofit.PokemonsApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ServicesModule {
    @Provides
    fun pokemonsApiService(): PokemonsApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.pokemontcg.io/")
            .build()
            .create(PokemonsApiService::class.java)
    }
}