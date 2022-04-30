package com.gaziev.data.repository.mapper

interface Mapper<T, V> {
    fun mapTo(t: T): V
    fun mapFrom(v: V): T
}