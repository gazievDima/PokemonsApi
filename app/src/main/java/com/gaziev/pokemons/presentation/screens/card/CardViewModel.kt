package com.gaziev.pokemons.presentation.screens.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import javax.inject.Inject

class CardViewModel @Inject constructor() : ViewModel() {

    private val _pokemonLocal: MutableLiveData<PokemonLocalDetails> = MutableLiveData()
    val pokemonLocal: LiveData<PokemonLocalDetails> = _pokemonLocal

    private val _pokemonRemote: MutableLiveData<PokemonRemoteDetails> = MutableLiveData()
    val pokemonRemote: LiveData<PokemonRemoteDetails> = _pokemonRemote

    var flagLocalPokemon: Boolean = false

    fun setLocalPokemon(pokemon: PokemonLocalDetails) {
        _pokemonLocal.value = pokemon
    }

    fun setRemotePokemon(pokemon: PokemonRemoteDetails) {
        _pokemonRemote.value = pokemon
    }
}