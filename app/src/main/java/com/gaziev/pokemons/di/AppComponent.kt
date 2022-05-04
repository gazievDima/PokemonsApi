package com.gaziev.pokemons.di

import android.app.Application
import com.gaziev.pokemons.di.modules.*
import com.gaziev.pokemons.presentation.MainActivity
import com.gaziev.pokemons.presentation.screens.card.CardFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.health.HealthFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.latest.LatestFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.names.NamesFragment
import com.gaziev.pokemons.presentation.screens.pokemons.PokemonsFragment
import com.gaziev.pokemons.presentation.screens.welcome.WelcomeFragment
import dagger.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        MapperModule::class,
        RepositoryModule::class,
        SourceModule::class,
        ViewModelModule::class,
        UseCaseModule::class,
        DispatchersModule::class,
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: CardFragment)
    fun inject(fragment: WelcomeFragment)
    fun inject(fragment: PokemonsFragment)
    fun inject(fragment: HealthFragment)
    fun inject(fragment: NamesFragment)
    fun inject(fragment: LatestFragment)
}

@Module
class AppModule(app: Application) {

    val application: Application = app

    @Provides
    fun provideApplication(): Application {
        return application
    }
}