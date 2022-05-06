package com.gaziev.data.sources.local

import androidx.room.*
import com.gaziev.data.models.PokemonLocalEntity

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemonlocalentity")
    suspend fun getAll(): List<PokemonLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: PokemonLocalEntity)

    @Query("DELETE FROM pokemonlocalentity WHERE id = :idPokemon")
    suspend fun delete(idPokemon: String)

    @Query("SELECT * FROM pokemonlocalentity WHERE id = :idPokemon")
    suspend fun search(idPokemon: String): List<PokemonLocalEntity>

}