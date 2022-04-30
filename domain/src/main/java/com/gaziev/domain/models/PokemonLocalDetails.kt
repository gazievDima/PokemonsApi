package com.gaziev.domain.models

import com.gaziev.domain.usecases.search.Compared
import java.io.Serializable

class PokemonLocalDetails(
    val primary_key: Int,
    val id: String,
    val name: String,
    val supertype: String,
    val hp: Int,
    val number: Int,
    val artist: String,
    val rarity: String,
    val flavorText: String
) : Compared, Serializable {

    override fun equalsFields(element: String): Boolean {
      return id.contains(element) ||
              name.contains(element) ||
              supertype.contains(element) ||
              artist.contains(element) ||
              rarity.contains(element) ||
              flavorText.contains(element)
    }

}