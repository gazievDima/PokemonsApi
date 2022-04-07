package com.gaziev.pokemons

import com.gaziev.pokemons.ui.models.PokemonUI

class PokemonApi {

    companion object {
        fun getPokemonsList(): MutableList<PokemonUI> {
            val list: MutableList<PokemonUI> = mutableListOf()
            for(i in 1..18) {
                list.add(PokemonUI("Pikachu $i"))
            }
            return list
        }
    }
}