package com.gaziev.pokemons.di.modules

import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.repository.mapper.Mapper
import com.gaziev.data.repository.sources.PokemonLocalSource
import com.gaziev.data.sources.local.PokemonLocalSourceImpl
import com.gaziev.data.sources.remote.PokemonsApiService
import com.gaziev.data.sources.remote.PokemonsPagingSourceImpl
import com.gaziev.domain.models.PokemonRemoteDetails
import dagger.Module
import dagger.Provides

@Module
class SourceModule {

    @Provides
    fun providePokemonLocalSource(): PokemonLocalSource {
        return PokemonLocalSourceImpl()
    }

    @Provides
    fun providePokemonsPagingSource(
        pokemonsApiService: PokemonsApiService,
        mapper: Mapper<PokemonRemoteEntity, PokemonRemoteDetails>
    ): PokemonsPagingSourceImpl {
        return PokemonsPagingSourceImpl(pokemonsApiService, mapper)
    }

}