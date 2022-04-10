package com.gaziev.pokemons.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaziev.data.repository.GetApiPokemonsRepository
import com.gaziev.data.repository.GetFavoritePokemonsRepository
import com.gaziev.pokemons.repository.GetApiPokemons
import com.gaziev.pokemons.repository.GetFavoritePokemons
import com.gaziev.pokemons.ui.screens.favorites.pager.latest.LatestViewModel
import com.gaziev.pokemons.ui.screens.favorites.pager.health.HealthViewModel
import com.gaziev.pokemons.ui.screens.favorites.pager.names.NamesViewModel
import com.gaziev.pokemons.ui.screens.pokemons.PokemonsViewModel

class ViewModelFactory : ViewModelProvider.Factory {

    private val getFavoritePokemons: GetFavoritePokemons = GetFavoritePokemonsRepository()
    private val getApiPokemons: GetApiPokemons = GetApiPokemonsRepository()

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(PokemonsViewModel::class.java) -> return PokemonsViewModel(getApiPokemons) as T
            modelClass.isAssignableFrom(LatestViewModel::class.java) -> return LatestViewModel(getFavoritePokemons) as T
            modelClass.isAssignableFrom(HealthViewModel::class.java) -> return HealthViewModel(getFavoritePokemons) as T
            modelClass.isAssignableFrom(NamesViewModel::class.java) -> return NamesViewModel(getFavoritePokemons) as T
        }
        return modelClass.newInstance()
    }
}