package com.gaziev.pokemons.di.modules

import com.gaziev.data.repository.PokemonRepositoryImpl
import com.gaziev.domain.comparator.PokemonComparatorImpl
import com.gaziev.domain.dispatcher.DefaultDispatcher
import com.gaziev.domain.usecases.delete.DeleteFavoritePokemonUseCase
import com.gaziev.domain.usecases.get.GetFavoritesPokemonsUseCase
import com.gaziev.domain.usecases.get.GetPokemonsUseCase
import com.gaziev.domain.usecases.save.SaveFavoritePokemonUseCase
import com.gaziev.domain.usecases.search.Compared
import com.gaziev.domain.usecases.search.SearchFavoritePokemonUseCase
import com.gaziev.domain.usecases.search.SearchInFieldsDetailsUseCase
import com.gaziev.domain.usecases.sort.SortedPokemonsByHealthUseCase
import com.gaziev.domain.usecases.sort.SortedPokemonsByLatestUseCase
import com.gaziev.domain.usecases.sort.SortedPokemonsByNamesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideSearchFavoritePokemonUseCase(
        repository: PokemonRepositoryImpl,
        dispatcher: DefaultDispatcher
    ): SearchFavoritePokemonUseCase {
        return SearchFavoritePokemonUseCase(repository, dispatcher)
    }

    @Provides
    fun provideGetFavoritesPokemonsUseCase(
        repository: PokemonRepositoryImpl,
        dispatcher: DefaultDispatcher
    ): GetFavoritesPokemonsUseCase {
        return GetFavoritesPokemonsUseCase(repository, dispatcher)
    }

    @Provides
    fun provideGetPokemonsUseCase(
        repository: PokemonRepositoryImpl,
        dispatcher: DefaultDispatcher
    ): GetPokemonsUseCase {
        return GetPokemonsUseCase(repository, dispatcher)
    }

    @Provides
    fun provideDeleteFavoritePokemonUseCase(
        repository: PokemonRepositoryImpl,
        dispatcher: DefaultDispatcher
    ): DeleteFavoritePokemonUseCase {
        return DeleteFavoritePokemonUseCase(repository, dispatcher)
    }

    @Provides
    fun provideSaveFavoritePokemonUseCase(
        repository: PokemonRepositoryImpl,
        dispatcher: DefaultDispatcher
    ): SaveFavoritePokemonUseCase {
        return SaveFavoritePokemonUseCase(repository, dispatcher)
    }

    @Provides
    fun provideSortedPokemonByHealthUseCase(
        pokemonComparatorHealthUp: PokemonComparatorImpl.HealthUP,
        pokemonComparatorHealthDown: PokemonComparatorImpl.HealthDown,
        dispatcher: DefaultDispatcher
    ) : SortedPokemonsByHealthUseCase {
        return SortedPokemonsByHealthUseCase(pokemonComparatorHealthUp, pokemonComparatorHealthDown, dispatcher)
    }

    @Provides
    fun provideSortedPokemonsByLatestUseCase(
        pokemonComparatorLatestUp: PokemonComparatorImpl.LatestUp,
        pokemonComparatorLatestDown: PokemonComparatorImpl.LatestDown,
        dispatcher: DefaultDispatcher
    ): SortedPokemonsByLatestUseCase {
        return SortedPokemonsByLatestUseCase(pokemonComparatorLatestUp, pokemonComparatorLatestDown, dispatcher)
    }

    @Provides
    fun provideSortedPokemonsByNamesUseCase(
        pokemonComparatorNameUp: PokemonComparatorImpl.NameUp,
        pokemonComparatorNameDown: PokemonComparatorImpl.NameDown,
        dispatcher: DefaultDispatcher
    ): SortedPokemonsByNamesUseCase {
        return SortedPokemonsByNamesUseCase(pokemonComparatorNameUp, pokemonComparatorNameDown, dispatcher)
    }

    @Provides
    fun provideSearchInFieldsDetailsUseCase(
        dispatcher: DefaultDispatcher
    ) : SearchInFieldsDetailsUseCase<Compared> {
        return SearchInFieldsDetailsUseCase(dispatcher)
    }

}