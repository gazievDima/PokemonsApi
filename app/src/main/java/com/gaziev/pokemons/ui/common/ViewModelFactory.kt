package com.gaziev.pokemons.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaziev.pokemons.ui.screens.pokemons.PokemonsViewModel

class ViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(PokemonsViewModel::class.java) -> return PokemonsViewModel() as T
        }
        return modelClass.newInstance()
    }
}