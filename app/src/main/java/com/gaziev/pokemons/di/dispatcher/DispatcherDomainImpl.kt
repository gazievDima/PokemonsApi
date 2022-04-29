package com.gaziev.pokemons.di.dispatcher

import com.gaziev.domain.common.DispatcherDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatcherDomainImpl @Inject constructor() :
    DispatcherDomain {

    override fun inject(): CoroutineDispatcher {
        return Dispatchers.Default
    }
}