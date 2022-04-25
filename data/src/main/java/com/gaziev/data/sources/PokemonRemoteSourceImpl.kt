package com.gaziev.data.sources

import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.repository.sources.PokemonRemoteSource
import javax.inject.Inject

class PokemonRemoteSourceImpl @Inject constructor() : PokemonRemoteSource {

    override fun getPokemons(): List<PokemonRemoteEntity> {
        return listOf<PokemonRemoteEntity>(
            PokemonRemoteEntity("aid-88", "Дима", "Electric", 33, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonRemoteEntity("aid-88", "Вася", "Electric", 42, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonRemoteEntity("aid-88", "Костя", "Electric", 89, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonRemoteEntity("aid-88", "Валера", "Electric", 19, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonRemoteEntity("aid-88", "Никита", "Electric", 69, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonRemoteEntity("aid-88", "Саша", "Electric", 59, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonRemoteEntity("aid-88", "Артем", "Electric", 44, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonRemoteEntity("aid-88", "Кирилл", "Electric", 32, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonRemoteEntity("aid-88", "Ярослав", "Electric", 28, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonRemoteEntity("aid-88", "Марат", "Electric", 87, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonRemoteEntity("aid-88", "Иван", "Electric", 39, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonRemoteEntity("aid-88", "Леша", "Electric", 19, 10, "Yellow hero", "Empty info", "Empty info")
        )
    }

}