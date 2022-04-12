package com.gaziev.data.storage.room

import com.gaziev.data.models.PokemonBDData
import com.gaziev.data.repository.source.ILocalDataBase

class PokemonRoomDataBase : ILocalDataBase {
    override fun deletePokemon(pokemon: PokemonBDData): Boolean {
        return true
    }

    override fun savePokemon(pokemon: PokemonBDData): Boolean {
        return true
    }

    override fun getPokemons(): List<PokemonBDData> {
        return listOf(
            PokemonBDData(3, "aid-88", "Дима", "Electric", 33, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDData(1, "aid-88", "Вася", "Electric", 42, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDData(2, "aid-88", "Костя", "Electric", 89, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDData(4, "aid-88", "Валера", "Electric", 19, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDData(6, "aid-88", "Никита", "Electric", 69, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDData(5, "aid-88", "Саша", "Electric", 59, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDData(7, "aid-88", "Артем", "Electric", 44, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDData(9, "aid-88", "Кирилл", "Electric", 32, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDData(8, "aid-88", "Ярослав", "Electric", 28, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDData(12, "aid-88", "Марат", "Electric", 87, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDData(11, "aid-88", "Иван", "Electric", 39, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDData(10, "aid-88", "Леша", "Electric", 19, 10, "Yellow hero", "Empty info", "Empty info"),
        )
    }

}