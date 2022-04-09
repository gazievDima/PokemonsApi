package com.gaziev.pokemons.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaziev.pokemons.ui.screens.favorites.pager.az.AZViewModel
import com.gaziev.pokemons.ui.screens.favorites.pager.health.HealthViewModel
import com.gaziev.pokemons.ui.screens.favorites.pager.strong.StrongViewModel
import com.gaziev.pokemons.ui.screens.pokemons.PokemonsViewModel

class ViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(PokemonsViewModel::class.java) -> return PokemonsViewModel() as T
            modelClass.isAssignableFrom(AZViewModel::class.java) -> return AZViewModel() as T
            modelClass.isAssignableFrom(HealthViewModel::class.java) -> return HealthViewModel() as T
            modelClass.isAssignableFrom(StrongViewModel::class.java) -> return StrongViewModel() as T
        }
        return modelClass.newInstance()
    }
}