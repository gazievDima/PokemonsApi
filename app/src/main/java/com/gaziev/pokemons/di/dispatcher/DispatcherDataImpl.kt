package com.gaziev.pokemons.di.dispatcher

import com.gaziev.data.common.DispatcherData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatcherDataImpl @Inject constructor() :
    DispatcherData {

    override fun inject(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}