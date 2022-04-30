package com.gaziev.pokemons.dispatcher

import com.gaziev.domain.usecases.DispatcherDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatcherDomainImpl @Inject constructor() :
    DispatcherDomain {

    override fun inject(): CoroutineDispatcher {
        return Dispatchers.Default
    }
}