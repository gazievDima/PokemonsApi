package com.gaziev.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.models.converters.ImagesLocalEntityConverter
import com.gaziev.data.models.converters.ListStringConverter

@Database(entities = [PokemonLocalEntity::class], version = 2)
@TypeConverters(ImagesLocalEntityConverter::class, ListStringConverter::class)
abstract class PokemonDataBase : RoomDatabase() {
    abstract fun instanceDataBase(): PokemonDao

    companion object {
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE pokemonlocalentity_backup (primary_key INTEGER, id TEXT, name TEXT, supertype TEXT, hp TEXT, artist TEXT, images TEXT, PRIMARY KEY (primary_key))")
                database.execSQL("INSERT INTO pokemonlocalentity_backup SELECT primary_key, id, name, supertype, hp, artist, images FROM pokemonlocalentity")
                database.execSQL("DROP TABLE pokemonlocalentity")
                database.execSQL("ALTER TABLE pokemonlocalentity_backup RENAME to pokemonlocalentity")
            }
        }
    }
}