package com.gaziev.pokemons.di

import com.gaziev.pokemons.di.modules.*
import com.gaziev.pokemons.presentation.screens.favorites.pager.health.HealthFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.latest.LatestFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.names.NamesFragment
import com.gaziev.pokemons.presentation.screens.pokemons.PokemonsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MapperModule::class,
        RepositoryModule::class,
        SourceModule::class,
        ViewModelModule::class,
        UseCaseModule::class,
        DispatchersModule::class,
        ServicesModule::class
    ]
)

interface AppComponent {

    fun inject(fragment: PokemonsFragment)
    fun inject(fragment: NamesFragment)
    fun inject(fragment: LatestFragment)
    fun inject(fragment: HealthFragment)
}