package com.gaziev.pokemons.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaziev.domain.repository.IGetApiPokemonsRepository
import com.gaziev.domain.usecases.get.GetApiPokemonsUseCase
import com.gaziev.domain.usecases.get.GetFavoritePokemonsUseCase
import com.gaziev.pokemons.ui.screens.favorites.pager.latest.LatestViewModel
import com.gaziev.pokemons.ui.screens.favorites.pager.health.HealthViewModel
import com.gaziev.pokemons.ui.screens.favorites.pager.names.NamesViewModel
import com.gaziev.pokemons.ui.screens.pokemons.PokemonsViewModel
import com.gaziev.data.repository.*
import com.gaziev.data.repository.source.ILocalDataBase
import com.gaziev.data.repository.source.INetworkApi
import com.gaziev.data.storage.api.PokemonApiService
import com.gaziev.data.storage.room.PokemonRoomDataBase
import com.gaziev.domain.repository.IGetFavoritePokemonsRepository

class ViewModelFactory : ViewModelProvider.Factory {

    private val localDataBase: ILocalDataBase = PokemonRoomDataBase()
    private val apiService: INetworkApi = PokemonApiService()

    private val getFavoritePokemonsRepository: IGetFavoritePokemonsRepository = GetFavoritePokemonsRepository(localDataBase)
    private val getApiPokemonsRepository: IGetApiPokemonsRepository = GetApiPokemonsRepository(apiService)

    private val getFavoritePokemonsUseCase: GetFavoritePokemonsUseCase = GetFavoritePokemonsUseCase(getFavoritePokemonsRepository)
    private val getApiPokemonsUse: GetApiPokemonsUseCase = GetApiPokemonsUseCase(getApiPokemonsRepository)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(PokemonsViewModel::class.java) -> return PokemonsViewModel(getApiPokemonsUse) as T
            modelClass.isAssignableFrom(LatestViewModel::class.java) -> return LatestViewModel(getFavoritePokemonsUseCase) as T
            modelClass.isAssignableFrom(HealthViewModel::class.java) -> return HealthViewModel(getFavoritePokemonsUseCase) as T
            modelClass.isAssignableFrom(NamesViewModel::class.java) -> return NamesViewModel(getFavoritePokemonsUseCase) as T
        }
        return modelClass.newInstance()
    }
}