package com.gaziev.pokemons.di.modules

import com.gaziev.data.common.DispatcherData
import dagger.Module
import dagger.Provides
import com.gaziev.domain.common.DispatcherDomain
import com.gaziev.pokemons.di.dispatcher.DispatcherDataImpl
import com.gaziev.pokemons.di.dispatcher.DispatcherDomainImpl

@Module
class DispatchersModule {

    @Provides
    fun provideDispatcherData(): DispatcherData {
        return DispatcherDataImpl()
    }

    @Provides
    fun provideDispatcherDomain(): DispatcherDomain {
        return DispatcherDomainImpl()
    }
}