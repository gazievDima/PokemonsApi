package com.gaziev.pokemons.di.modules

import com.gaziev.data.mapper.IMapper
import com.gaziev.data.mapper.PokemonLocalMapper
import com.gaziev.data.mapper.PokemonRemoteMapper
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun providePokemonLocalMapper(): IMapper<PokemonLocalEntity, PokemonLocalDetails> {
        return PokemonLocalMapper()
    }

    @Provides
    fun providePokemonRemoteMapper(): IMapper<PokemonRemoteEntity, PokemonRemoteDetails> {
        return PokemonRemoteMapper()
    }

}