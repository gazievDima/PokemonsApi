package com.gaziev.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherDomain {
    fun inject(): CoroutineDispatcher
}