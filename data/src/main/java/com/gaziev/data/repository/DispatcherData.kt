package com.gaziev.data.repository

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherData {
    fun inject(): CoroutineDispatcher
}