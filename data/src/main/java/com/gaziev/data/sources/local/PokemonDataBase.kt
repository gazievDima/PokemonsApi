package com.gaziev.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.models.converters.ImagesLocalEntityConverter
import com.gaziev.data.models.converters.ListStringConverter

@Database(entities = [PokemonLocalEntity::class], version = 1)
@TypeConverters(ImagesLocalEntityConverter::class, ListStringConverter::class)
abstract class PokemonDataBase : RoomDatabase() {
    abstract fun instanceDataBase(): PokemonDao
}