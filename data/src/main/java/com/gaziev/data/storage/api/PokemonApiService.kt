package com.gaziev.data.storage.api

import com.gaziev.data.models.PokemonApiDaoData
import com.gaziev.data.repository.source.INetworkApi

class PokemonApiService : INetworkApi {
    override fun getPokemons(): List<PokemonApiDaoData> {
        return listOf(
            PokemonApiDaoData("aid-88", "Дима", "Electric", 33, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonApiDaoData("aid-88", "Вася", "Electric", 42, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonApiDaoData("aid-88", "Костя", "Electric", 89, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonApiDaoData("aid-88", "Валера", "Electric", 19, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonApiDaoData("aid-88", "Никита", "Electric", 69, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonApiDaoData("aid-88", "Саша", "Electric", 59, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonApiDaoData("aid-88", "Артем", "Electric", 44, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonApiDaoData("aid-88", "Кирилл", "Electric", 32, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonApiDaoData("aid-88", "Ярослав", "Electric", 28, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonApiDaoData("aid-88", "Марат", "Electric", 87, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonApiDaoData("aid-88", "Иван", "Electric", 39, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonApiDaoData("aid-88", "Леша", "Electric", 19, 10, "Yellow hero", "Empty info", "Empty info"),
            )
    }

    override fun getPokemonsPage(pageNumber: Int, pageSize: Int): List<PokemonApiDaoData> {
        return emptyList()
    }
}