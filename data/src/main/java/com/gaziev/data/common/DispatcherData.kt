package com.gaziev.data.common

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherData {
    fun inject(): CoroutineDispatcher
}