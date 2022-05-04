package com.gaziev.data.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.gaziev.domain.models.ImagesDetails

@Entity(
    indices = [Index(
        value = ["id", "name", "supertype", "hp", "number", "artist", "rarity", "flavorText"],
        unique = true
    )]
)
class PokemonLocalEntity(
    @PrimaryKey(autoGenerate = true)
    val primary_key: Int?,
    val id: String?,
    val name: String?,
    val supertype: String?,
    val subtypes: List<String>?,
    val hp: String?,
    val types: List<String>?,
    val evolvesTo: List<String>?,
    val rules: List<String>?,
    val artist: String?,
    val rarity: String?,
    val images: ImagesDetails?
) {
}