package com.gaziev.domain.comparator

import com.gaziev.domain.models.PokemonLocalDetails
import javax.inject.Inject

class PokemonComparatorImpl {

    class LatestUp @Inject constructor() : Comparator<PokemonLocalDetails> {
        override fun compare(p0: PokemonLocalDetails, p1: PokemonLocalDetails): Int =
            p0.primary_key!! - p1.primary_key!!
    }

    class LatestDown @Inject constructor() : Comparator<PokemonLocalDetails> {
        override fun compare(p0: PokemonLocalDetails, p1: PokemonLocalDetails): Int =
            p1.primary_key!! - p0.primary_key!!
    }

    class NameUp @Inject constructor() : Comparator<PokemonLocalDetails> {
        override fun compare(p0: PokemonLocalDetails, p1: PokemonLocalDetails): Int =
            p0.name!!.compareTo(p1.name!!)
    }

    class NameDown @Inject constructor() : Comparator<PokemonLocalDetails> {
        override fun compare(p0: PokemonLocalDetails, p1: PokemonLocalDetails): Int =
            p1.name!!.compareTo(p0.name!!)
    }

    class HealthUP @Inject constructor() : Comparator<PokemonLocalDetails> {
        override fun compare(p0: PokemonLocalDetails, p1: PokemonLocalDetails): Int =
            p0.hp!!.toInt() - p1.hp!!.toInt()
    }

    class HealthDown @Inject constructor() : Comparator<PokemonLocalDetails> {
        override fun compare(p0: PokemonLocalDetails, p1: PokemonLocalDetails): Int =
            p1.hp!!.toInt() - p0.hp!!.toInt()
    }
}