package com.gaziev.domain.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DefaultDispatcher @Inject constructor() : DispatcherCoroutine {
    override fun get(): CoroutineDispatcher = Dispatchers.Default
}