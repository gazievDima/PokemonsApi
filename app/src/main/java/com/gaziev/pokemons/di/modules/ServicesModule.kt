package com.gaziev.pokemons.di.modules

import com.gaziev.data.sources.remote.PokemonsApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ServicesModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.pokemontcg.io/")
            .build()
    }

    @Singleton
    @Provides
    fun pokemonsApiService(retrofit: Retrofit): PokemonsApiService {
        return retrofit.create(PokemonsApiService::class.java)
    }
}