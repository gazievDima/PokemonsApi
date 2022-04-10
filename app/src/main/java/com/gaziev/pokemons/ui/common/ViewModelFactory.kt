package com.gaziev.pokemons.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaziev.pokemons.ui.screens.favorites.pager.latest.LatestViewModel
import com.gaziev.pokemons.ui.screens.favorites.pager.health.HealthViewModel
import com.gaziev.pokemons.ui.screens.favorites.pager.names.NamesViewModel
import com.gaziev.pokemons.ui.screens.pokemons.PokemonsViewModel
import com.gaziev.pokemons.ui.usecase.GetPokemonsUseCase

class ViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(PokemonsViewModel::class.java) -> return PokemonsViewModel() as T
            modelClass.isAssignableFrom(LatestViewModel::class.java) -> return LatestViewModel() as T
            modelClass.isAssignableFrom(HealthViewModel::class.java) -> return HealthViewModel() as T
            modelClass.isAssignableFrom(NamesViewModel::class.java) -> return NamesViewModel() as T
        }
        return modelClass.newInstance()
    }
}