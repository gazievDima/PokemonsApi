package com.gaziev.data.mapper

interface IMapper<T, V> {
    fun mapTo(t: T): V
    fun mapFrom(v: V): T
}