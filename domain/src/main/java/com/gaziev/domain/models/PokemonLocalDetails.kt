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
}

class ImagesLocalDetails(val small: String?, val large: String?)

