package com.gaziev.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.models.converter.ConverterImagesEntity
import com.gaziev.data.models.converter.ConverterListStrings

@Database(entities = [PokemonLocalEntity::class], version = 3)
@TypeConverters(ConverterImagesEntity::class, ConverterListStrings::class)
abstract class PokemonDataBase : RoomDatabase() {
    abstract fun instanceDataBase(): PokemonDao
}