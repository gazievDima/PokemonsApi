package com.gaziev.pokemons.ui.screens.favorites.pager.health

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.domain.models.PokemonBD
import com.gaziev.domain.usecases.get.GetFavoritePokemonsUseCase
import com.gaziev.domain.usecases.sort.SortHealthFavoritePokemonsUseCase

class HealthViewModel(
    private val getFavoritePokemonsUseCase: GetFavoritePokemonsUseCase,
    private val sortHealthFavoritePokemonsUseCase: SortHealthFavoritePokemonsUseCase
) : ViewModel() {

<<<<<<< HEAD
    private var _pokemons: MutableLiveData<List<PokemonBD>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<PokemonBD>> = _pokemons
=======
    private var stateSortedUp: Boolean = true
    private var _pokemons: MutableLiveData<List<PokemonBDDao>> = MutableLiveData(emptyList())
    val pokemons: LiveData<List<PokemonBDDao>> = _pokemons
>>>>>>> UI

    init {
        val listPokemons = getFavoritePokemonsUseCase.get()
        _pokemons.value = sortHealthFavoritePokemonsUseCase.up(listPokemons)
    }

    fun sortItems() {
        if (stateSortedUp) {
            _pokemons.value = sortHealthFavoritePokemonsUseCase.down(pokemons.value!!)
        } else {
            _pokemons.value = sortHealthFavoritePokemonsUseCase.up(pokemons.value!!)
        }
        stateSortedUp = !stateSortedUp
    }

}