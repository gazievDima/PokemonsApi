package com.gaziev.data.repository

interface Mapper<T, V> {
    fun mapTo(t: T): V
    fun mapFrom(v: V): T
}