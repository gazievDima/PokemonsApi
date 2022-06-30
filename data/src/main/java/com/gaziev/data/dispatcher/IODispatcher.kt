package com.gaziev.data.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class IODispatcher @Inject constructor() : DispatcherCoroutine {
    override fun get(): CoroutineDispatcher = Dispatchers.IO
}