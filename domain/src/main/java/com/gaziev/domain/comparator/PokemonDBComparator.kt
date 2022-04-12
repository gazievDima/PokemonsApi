package com.gaziev.domain.comparator

import com.gaziev.domain.models.PokemonBD

class PokemonBDDaoComparator {

    class LatestUp : Comparator<PokemonBD> {
        override fun compare(p0: PokemonBD, p1: PokemonBD): Int =
            p0.primary_key - p1.primary_key
    }

    class LatestDown : Comparator<PokemonBD> {
        override fun compare(p0: PokemonBD, p1: PokemonBD): Int =
            p1.primary_key - p0.primary_key
    }

    class NameUp : Comparator<PokemonBD> {
        override fun compare(p0: PokemonBD, p1: PokemonBD): Int =
            p0.name.compareTo(p1.name)
    }

    class NameDown : Comparator<PokemonBD> {
        override fun compare(p0: PokemonBD, p1: PokemonBD): Int =
            p1.name.compareTo(p0.name)
    }

    class HealthUP : Comparator<PokemonBD> {
        override fun compare(p0: PokemonBD, p1: PokemonBD): Int =
            p0.hp - p1.hp
    }

    class HealthDown : Comparator<PokemonBD> {
        override fun compare(p0: PokemonBD, p1: PokemonBD): Int =
            p1.hp - p0.hp
    }
}