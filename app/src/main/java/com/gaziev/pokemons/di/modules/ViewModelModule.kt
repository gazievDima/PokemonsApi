package com.gaziev.pokemons.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaziev.pokemons.presentation.common.MainViewModelFactory
import com.gaziev.pokemons.presentation.screens.card.CardViewModel
import com.gaziev.pokemons.presentation.screens.favorites.pager.health.HealthViewModel
import com.gaziev.pokemons.presentation.screens.favorites.pager.latest.LatestViewModel
import com.gaziev.pokemons.presentation.screens.favorites.pager.names.NamesViewModel
import com.gaziev.pokemons.presentation.screens.pokemons.PokemonsViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: MainViewModelFactory): ViewModelProvider.Factory

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

    @Binds
    @IntoMap
    @ViewModelKey(CardViewModel::class)
    abstract fun bindCardViewModel(viewModel: CardViewModel): ViewModel

}