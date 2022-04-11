package com.gaziev.data.storage.room

import com.gaziev.data.models.PokemonApiDaoData
import com.gaziev.data.models.PokemonBDDaoData
import com.gaziev.data.repository.source.ILocalDataBase

class PokemonRoomDataBase : ILocalDataBase {
    override fun deletePokemon(pokemon: PokemonBDDaoData): Boolean {
        return true
    }

    override fun savePokemon(pokemon: PokemonBDDaoData): Boolean {
        return true
    }

    override fun getPokemons(): List<PokemonBDDaoData> {
        return listOf(
            PokemonBDDaoData(3, "aid-88", "Дима", "Electric", 33, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDDaoData(1, "aid-88", "Вася", "Electric", 42, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDDaoData(2, "aid-88", "Костя", "Electric", 89, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDDaoData(4, "aid-88", "Валера", "Electric", 19, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDDaoData(6, "aid-88", "Никита", "Electric", 69, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDDaoData(5, "aid-88", "Саша", "Electric", 59, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDDaoData(7, "aid-88", "Артем", "Electric", 44, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDDaoData(9, "aid-88", "Кирилл", "Electric", 32, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDDaoData(8, "aid-88", "Ярослав", "Electric", 28, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDDaoData(12, "aid-88", "Марат", "Electric", 87, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDDaoData(11, "aid-88", "Иван", "Electric", 39, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonBDDaoData(10, "aid-88", "Леша", "Electric", 19, 10, "Yellow hero", "Empty info", "Empty info"),
        )
    }

}