package com.gaziev.domain.models

import com.gaziev.domain.usecases.search.Compared
import java.io.Serializable

class PokemonLocalDetails(
    var primary_key: Int? = null,
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
    val images: ImagesLocalDetails?

) : Compared, Serializable {

    override fun equalsFields(element: String): Boolean {
      return id!!.uppercase().contains(element.uppercase()) ||
            name!!.uppercase().contains(element.uppercase()) ||
            supertype!!.uppercase().contains(element.uppercase()) ||
              hp!!.uppercase().contains(element.uppercase()) ||
              artist!!.uppercase().contains(element.uppercase()) ||
              rarity!!.uppercase().contains(element.uppercase())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PokemonLocalDetails

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

class ImagesLocalDetails(val small: String?, val large: String?) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ImagesLocalDetails

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
