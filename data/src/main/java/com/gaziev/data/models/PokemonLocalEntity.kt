package com.gaziev.data.models

import androidx.room.*
import com.gaziev.data.models.converter.ConverterImagesEntity
import com.gaziev.data.models.converter.ConverterListStrings
import retrofit2.Converter

@Entity
@TypeConverters(ConverterListStrings::class, ConverterImagesEntity::class)
class PokemonLocalEntity(
    @PrimaryKey(autoGenerate = true) var primary_key: Int? = null,
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
    val images: ImagesEntity?
)