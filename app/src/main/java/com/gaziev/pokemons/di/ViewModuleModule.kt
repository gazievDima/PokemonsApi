package com.gaziev.pokemons.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaziev.pokemons.presentation.ViewModelFactory
import com.gaziev.pokemons.presentation.screens.favorites.pager.health.HealthViewModel
import com.gaziev.pokemons.presentation.screens.favorites.pager.latest.LatestViewModel
import com.gaziev.pokemons.presentation.screens.favorites.pager.names.NamesViewModel
import com.gaziev.pokemons.presentation.screens.pokemons.PokemonsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PokemonsViewModel::class)
    abstract fun bindPokemonsViewModel(viewModel: PokemonsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LatestViewModel::class)
    abstract fun bindLatestViewModel(viewModel: LatestViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HealthViewModel::class)
    abstract fun bindHealthViewModel(viewModel: HealthViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NamesViewModel::class)
    abstract fun bindNamesViewModel(viewModel: NamesViewModel): ViewModel

}