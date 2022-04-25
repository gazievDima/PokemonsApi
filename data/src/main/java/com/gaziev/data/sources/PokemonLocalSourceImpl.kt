package com.gaziev.data.sources

import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.repository.sources.PokemonLocalSource
import javax.inject.Inject

class PokemonLocalSourceImpl @Inject constructor() : PokemonLocalSource {

    override fun getCachePokemons(): List<PokemonLocalEntity> = TODO()
    override fun getFavoritesPokemons(): List<PokemonLocalEntity> {
        return listOf(
            PokemonLocalEntity(3, "aad-88", "Дима", "Electric", 33, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonLocalEntity(1, "aad-88", "Вася", "Electric", 42, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonLocalEntity(2, "www-88", "Костя", "Electric", 89, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonLocalEntity(4, "www-88", "Валера", "Electric", 19, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonLocalEntity(6, "sss-88", "Никита", "Electric", 69, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonLocalEntity(5, "sss-88", "Саша", "Electric", 59, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonLocalEntity(7, "ddd-88", "Артем", "Electric", 44, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonLocalEntity(9, "ddd-88", "Кирилл", "Electric", 32, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonLocalEntity(8, "rrr-88", "Ярослав", "Electric", 28, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonLocalEntity(12, "rrr-88", "Марат", "Electric", 87, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonLocalEntity(11, "qqq", "Иван", "Electric", 39, 10, "Yellow hero", "Empty info", "Empty info"),
            PokemonLocalEntity(10, "qqq-88", "Леша", "Electric", 19, 10, "Yellow hero", "Empty info", "Empty info")
        )
    }
    override fun deletePokemon(pokemon: PokemonLocalEntity): Boolean = TODO()
    override fun savePokemon(pokemon: PokemonLocalEntity): Boolean = TODO()


}