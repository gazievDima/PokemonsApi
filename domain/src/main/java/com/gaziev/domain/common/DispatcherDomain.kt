package com.gaziev.domain.common

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherDomain {
    fun inject(): CoroutineDispatcher
}