package com.gaziev.pokemons.di.modules

import com.gaziev.data.repository.mapper.Mapper
import com.gaziev.data.mapper.ImagesRemoteMapperImpl
import com.gaziev.data.mapper.PokemonLocalMapperImpl
import com.gaziev.data.mapper.PokemonRemoteMapperImpl
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun providePokemonLocalMapper(): Mapper<PokemonLocalEntity, PokemonLocalDetails> {
        return PokemonLocalMapperImpl()
    }

    @Provides
    fun providePokemonRemoteMapper(
        imagesRemoteMapper: ImagesRemoteMapperImpl
    ): Mapper<PokemonRemoteEntity, PokemonRemoteDetails> {
        return PokemonRemoteMapperImpl(imagesRemoteMapper)
    }

}