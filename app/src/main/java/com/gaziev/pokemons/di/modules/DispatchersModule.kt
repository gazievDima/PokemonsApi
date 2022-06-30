package com.gaziev.pokemons.di.modules

import com.gaziev.data.dispatcher.IODispatcher
import com.gaziev.domain.dispatcher.DefaultDispatcher
import dagger.Module
import dagger.Provides

@Module
class DispatchersModule {
    @Provides
    fun provideDefaultDispatcherDomain(): com.gaziev.domain.dispatcher.DispatcherCoroutine {
        return DefaultDispatcher()
    }

    @Provides
    fun provideIODispatcherData(): com.gaziev.data.dispatcher.DispatcherCoroutine {
        return IODispatcher()
    }
}