package com.gaziev.data.sources.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.gaziev.data.models.PokemonLocalEntity

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemonlocalentity")
    suspend fun getAll(): List<PokemonLocalEntity>

    @Insert
    suspend fun insert(pokemon: PokemonLocalEntity)

    @Delete
    suspend fun delete(pokemon: PokemonLocalEntity)
}