package com.gaziev.pokemons.di.modules

import android.content.ContentValues.TAG
import android.util.Log
import com.gaziev.data.sources.remote.PokemonsApiService
import com.gaziev.pokemons.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    fun provideOkhttp(): OkHttpClient {
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("X-Api-Key", BuildConfig.API_KEY)
                .build()
            chain.proceed(request)
        }
        return client.build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl("https://api.pokemontcg.io/")
            .build()
    }

    @Singleton
    @Provides
    fun pokemonsApiService(retrofit: Retrofit): PokemonsApiService {
        return retrofit.create(PokemonsApiService::class.java)
    }
}