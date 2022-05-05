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
            "subtypes",
            "hp",
            "types",
            "evolvesTo",
            "rules",
            "artist",
            "rarity",
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
    val subtypes: List<String>?,
    val hp: String?,
    val types: List<String>?,
    val evolvesTo: List<String>?,
    val rules: List<String>?,
    val artist: String?,
    val rarity: String?,
    val images: ImagesLocalEntity?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PokemonLocalEntity

        if (primary_key != other.primary_key) return false
        if (id != other.id) return false
        if (name != other.name) return false
        if (supertype != other.supertype) return false
        if (subtypes != other.subtypes) return false
        if (hp != other.hp) return false
        if (types != other.types) return false
        if (evolvesTo != other.evolvesTo) return false
        if (rules != other.rules) return false
        if (artist != other.artist) return false
        if (rarity != other.rarity) return false
        if (images != other.images) return false

        return true
    }

    override fun hashCode(): Int {
        var result = primary_key ?: 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (supertype?.hashCode() ?: 0)
        result = 31 * result + (subtypes?.hashCode() ?: 0)
        result = 31 * result + (hp?.hashCode() ?: 0)
        result = 31 * result + (types?.hashCode() ?: 0)
        result = 31 * result + (evolvesTo?.hashCode() ?: 0)
        result = 31 * result + (rules?.hashCode() ?: 0)
        result = 31 * result + (artist?.hashCode() ?: 0)
        result = 31 * result + (rarity?.hashCode() ?: 0)
        result = 31 * result + (images?.hashCode() ?: 0)
        return result
    }
}

class ImagesLocalEntity(val small: String?, val large: String?) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ImagesLocalEntity

        if (small != other.small) return false
        if (large != other.large) return false

        return true
    }

    override fun hashCode(): Int {
        var result = small?.hashCode() ?: 0
        result = 31 * result + (large?.hashCode() ?: 0)
        return result
    }
}