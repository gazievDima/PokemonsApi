package com.gaziev.pokemons.di.modules

import com.gaziev.data.repository.PokemonRepositoryImpl
import com.gaziev.domain.comparator.PokemonComparator
import com.gaziev.domain.usecases.delete.DeleteFavoritePokemonUseCase
import com.gaziev.domain.usecases.get.GetFavoritesPokemonsUseCase
import com.gaziev.domain.usecases.get.GetPokemonsUseCase
import com.gaziev.domain.usecases.save.SaveFavoritePokemonUseCase
import com.gaziev.domain.usecases.search.Compared
import com.gaziev.domain.usecases.search.SearchInFieldsDetailsUseCase
import com.gaziev.domain.usecases.sort.SortedPokemonsByHealthUseCase
import com.gaziev.domain.usecases.sort.SortedPokemonsByLatestUseCase
import com.gaziev.domain.usecases.sort.SortedPokemonsByNamesUseCase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class UseCaseModule {

    @Provides
    fun provideGetFavoritesPokemonsUseCase(
        repository: PokemonRepositoryImpl,
    ): GetFavoritesPokemonsUseCase {
        return GetFavoritesPokemonsUseCase(repository)
    }

    @Provides
    fun provideGetPokemonsUseCase(
        repository: PokemonRepositoryImpl,
    ): GetPokemonsUseCase {
        return GetPokemonsUseCase(repository)
    }

    @Provides
    fun provideDeleteFavoritePokemonUseCase(
        repository: PokemonRepositoryImpl,
    ): DeleteFavoritePokemonUseCase {
        return DeleteFavoritePokemonUseCase(repository)
    }

    @Provides
    fun provideSaveFavoritePokemonUseCase(
        repository: PokemonRepositoryImpl,
    ): SaveFavoritePokemonUseCase {
        return SaveFavoritePokemonUseCase(repository)
    }

    @Provides
    fun provideSortedPokemonByHealthUseCase(
        pokemonComparatorHealthUp: PokemonComparator.HealthUP,
        pokemonComparatorHealthDown: PokemonComparator.HealthDown,
    ) : SortedPokemonsByHealthUseCase {
        return SortedPokemonsByHealthUseCase(pokemonComparatorHealthUp, pokemonComparatorHealthDown)
    }

    @Provides
    fun provideSortedPokemonsByLatestUseCase(
        pokemonComparatorLatestUp: PokemonComparator.LatestUp,
        pokemonComparatorLatestDown: PokemonComparator.LatestDown,
    ): SortedPokemonsByLatestUseCase {
        return SortedPokemonsByLatestUseCase(pokemonComparatorLatestUp, pokemonComparatorLatestDown)
    }

    @Provides
    fun provideSortedPokemonsByNamesUseCase(
        pokemonComparatorNameUp: PokemonComparator.NameUp,
        pokemonComparatorNameDown: PokemonComparator.NameDown,
    ): SortedPokemonsByNamesUseCase {
        return SortedPokemonsByNamesUseCase(pokemonComparatorNameUp, pokemonComparatorNameDown)
    }

    @Provides
    fun provideSearchInFieldsDetailsUseCase(
    ) : SearchInFieldsDetailsUseCase<Compared> {
        return SearchInFieldsDetailsUseCase()
    }

}