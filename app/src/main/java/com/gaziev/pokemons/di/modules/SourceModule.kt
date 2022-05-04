package com.gaziev.pokemons.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.repository.Mapper
import com.gaziev.data.sources.local.PokemonDao
import com.gaziev.data.sources.local.PokemonDataBase
import com.gaziev.data.sources.remote.PokemonsApiService
import com.gaziev.data.sources.remote.PokemonsPagingSourceImpl
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.pokemons.App
import com.gaziev.pokemons.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class SourceModule {

    @Singleton
    @Provides
    fun providePokemonDataBase(
        context: Application
    ): PokemonDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            PokemonDataBase::class.java, "database-name"
        ).build()
    }

    @Singleton
    @Provides
    fun providePokemonDao(
        dataBase: PokemonDataBase
    ): PokemonDao {
        return dataBase.instanceDataBase()
    }

    @Provides
    fun providePokemonsPagingSource(
        pokemonsApiService: PokemonsApiService,
        mapper: Mapper<PokemonRemoteEntity, PokemonRemoteDetails>
    ): PokemonsPagingSourceImpl {
        return PokemonsPagingSourceImpl(pokemonsApiService, mapper)
    }

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

    @Singleton
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