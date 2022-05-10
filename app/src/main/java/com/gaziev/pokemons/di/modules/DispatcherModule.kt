package com.gaziev.pokemons.di.modules

import com.gaziev.data.repository.DispatcherData
import dagger.Module
import dagger.Provides
import com.gaziev.domain.usecases.DispatcherDomain
import com.gaziev.pokemons.dispatcher.DispatcherDataImpl
import com.gaziev.pokemons.dispatcher.DispatcherDomainImpl

@Module
class DispatcherModule {

    @Provides
    fun provideDispatcherData(): DispatcherData {
        return DispatcherDataImpl()
    }

    @Provides
    fun provideDispatcherDomain(): DispatcherDomain {
        return DispatcherDomainImpl()
    }
}