package com.gaziev.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gaziev.data.models.PokemonLocalEntity

@Database(entities = [PokemonLocalEntity::class], version = 1)
abstract class PokemonDataBase : RoomDatabase() {
    abstract fun instanceDataBase(): PokemonDao
}