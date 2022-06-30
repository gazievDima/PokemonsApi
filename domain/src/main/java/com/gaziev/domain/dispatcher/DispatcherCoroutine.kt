package com.gaziev.domain.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherCoroutine {
    fun get(): CoroutineDispatcher
}