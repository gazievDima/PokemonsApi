package com.gaziev.pokemons.di.modules

import com.gaziev.data.mapper.images.ImagesLocalMapperImpl
import com.gaziev.data.mapper.images.ImagesRemoteLocalMapperImpl
import com.gaziev.data.mapper.images.ImagesRemoteMapperImpl
import com.gaziev.data.mapper.pokemon.PokemonLocalMapperImpl
import com.gaziev.data.mapper.pokemon.PokemonRemoteLocalMapperImpl
import com.gaziev.data.mapper.pokemon.PokemonRemoteMapperImpl
import com.gaziev.data.repository.Mapper
import com.gaziev.data.models.ImagesLocalEntity
import com.gaziev.data.models.ImagesRemoteEntity
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.domain.models.ImagesLocalDetails
import com.gaziev.domain.models.ImagesRemoteDetails
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.pokemons.presentation.screens.card.model.PokemonCardMapperImpl
import com.gaziev.pokemons.presentation.screens.card.model.PokemonMapper
import dagger.Module
import dagger.Provides

@Module
class MappersModule {

    @Provides
    fun providePokemonRemoteMapper(
        mapper: ImagesLocalMapperImpl
    ): Mapper<PokemonLocalEntity, PokemonLocalDetails> {
        return PokemonLocalMapperImpl(mapper)
    }

    @Provides
    fun provideLocalRemoteMapper(
        mapper: ImagesRemoteMapperImpl
    ): Mapper<PokemonRemoteEntity, PokemonRemoteDetails> {
        return PokemonRemoteMapperImpl(mapper)
    }

    @Provides
    fun providePokemonRemoteLocalMapperImpl(
        mapper: ImagesRemoteLocalMapperImpl
    ): Mapper<PokemonRemoteDetails, PokemonLocalDetails> {
        return PokemonRemoteLocalMapperImpl(mapper)
    }

    @Provides
    fun provideImagesRemoteMapperImpl():
            Mapper<ImagesRemoteEntity, ImagesRemoteDetails> {
        return ImagesRemoteMapperImpl()
    }

    @Provides
    fun provideImagesLocalMapperImpl():
            Mapper<ImagesLocalEntity, ImagesLocalDetails> {
        return ImagesLocalMapperImpl()
    }

    @Provides
    fun provideImagesRemoteLocalMapperImpl():
            Mapper<ImagesRemoteDetails, ImagesLocalDetails> {
        return ImagesRemoteLocalMapperImpl()
    }

    @Provides
    fun providePokemonCardMapperImpl(
        mapper: ImagesRemoteLocalMapperImpl
    ): PokemonMapper {
        return PokemonCardMapperImpl(mapper)
    }

}