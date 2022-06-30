package com.gaziev.data.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherCoroutine {
    fun get(): CoroutineDispatcher
}