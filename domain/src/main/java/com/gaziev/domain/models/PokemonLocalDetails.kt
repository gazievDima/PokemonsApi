package com.gaziev.domain.models

import com.gaziev.domain.usecases.search.Compared
import java.io.Serializable

class PokemonLocalDetails(
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

) : Compared, Serializable {

    override fun equalsFields(element: String): Boolean {
      return id!!.contains(element) ||
            name!!.contains(element) ||
            supertype!!.contains(element) ||
              subtypes!!.contains(element) ||
              hp!!.contains(element) ||
              artist!!.contains(element) ||
              rarity!!.contains(element)
    }

}