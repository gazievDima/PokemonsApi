package com.gaziev.domain.comparator

import com.gaziev.domain.models.PokemonBDDao

class PokemonBDDaoComparator {

    class LatestUp : Comparator<PokemonBDDao> {
        override fun compare(p0: PokemonBDDao, p1: PokemonBDDao): Int =
            p0.primary_key - p1.primary_key
    }

    class LatestDown : Comparator<PokemonBDDao> {
        override fun compare(p0: PokemonBDDao, p1: PokemonBDDao): Int =
            p1.primary_key - p0.primary_key
    }

    class NameUp : Comparator<PokemonBDDao> {
        override fun compare(p0: PokemonBDDao, p1: PokemonBDDao): Int =
            p0.name.compareTo(p1.name)
    }

    class NameDown : Comparator<PokemonBDDao> {
        override fun compare(p0: PokemonBDDao, p1: PokemonBDDao): Int =
            p1.name.compareTo(p0.name)
    }

    class HealthUP : Comparator<PokemonBDDao> {
        override fun compare(p0: PokemonBDDao, p1: PokemonBDDao): Int =
            p0.hp - p1.hp
    }

    class HealthDown : Comparator<PokemonBDDao> {
        override fun compare(p0: PokemonBDDao, p1: PokemonBDDao): Int =
            p1.hp - p0.hp
    }
}