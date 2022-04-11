package com.gaziev.data.mapper

import com.gaziev.data.models.PokemonApiDaoData
import com.gaziev.data.models.PokemonBDDaoData
import com.gaziev.domain.models.PokemonApiDao
import com.gaziev.domain.models.PokemonBDDao

class FromData {

    fun mapTo(t: PokemonBDDaoData): PokemonBDDao {
        return PokemonBDDao(
            primary_key = t.primary_key,
            id = t.id,
            name = t.name,
            supertype = t.supertype,
            hp = t.hp,
            number = t.number,
            artist = t.artist,
            rarity = t.rarity,
            flavorText = t.flavorText
        )
    }

    fun mapTo(t: PokemonApiDaoData): PokemonApiDao {
        return PokemonApiDao(
            id = t.id,
            name = t.name,
            supertype = t.supertype,
            hp = t.hp,
            number = t.number,
            artist = t.artist,
            rarity = t.rarity,
            flavorText = t.flavorText
        )
    }
}