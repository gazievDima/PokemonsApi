package com.gaziev.pokemons.di

import com.gaziev.data.mapper.IMapper
import com.gaziev.data.mapper.PokemonLocalMapper
import com.gaziev.data.mapper.PokemonRemoteMapper
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.domain.models.PokemonLocal
import com.gaziev.domain.models.PokemonRemote
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun providePokemonLocalMapper(): IMapper<PokemonLocalEntity, PokemonLocal> {
        return PokemonLocalMapper()
    }

    @Provides
    fun providePokemonRemoteMapper(): IMapper<PokemonRemoteEntity, PokemonRemote> {
        return PokemonRemoteMapper()
    }

}