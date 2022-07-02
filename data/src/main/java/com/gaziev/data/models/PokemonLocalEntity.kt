package com.gaziev.data.models

import androidx.room.*
import com.gaziev.data.models.converters.ImagesLocalEntityConverter
import com.gaziev.data.models.converters.ListStringConverter

@Entity(
    indices = [
        Index(
            "id",
            "name",
            "supertype",
            "hp",
            "artist",
            "images",
            unique = true
        )]
)
@TypeConverters(ListStringConverter::class, ImagesLocalEntityConverter::class)
class PokemonLocalEntity(
    @PrimaryKey(autoGenerate = true) var primary_key: Int? = null,
    val id: String?,
    val name: String?,
    val supertype: String?,
    val hp: String?,
    val artist: String?,
    val images: ImagesLocalEntity?
)

class ImagesLocalEntity(val small: String?, val large: String?)
