package com.gaziev.pokemons.presentation.screens.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.usecases.delete.DeleteFavoritePokemonUseCase
import com.gaziev.domain.usecases.save.SaveFavoritePokemonUseCase
import com.gaziev.pokemons.presentation.screens.card.model.PokemonCard
import com.gaziev.pokemons.presentation.screens.card.model.PokemonCardMapperImpl
import com.gaziev.pokemons.presentation.screens.card.model.PokemonMapper
import javax.inject.Inject

class CardViewModel @Inject constructor(
    private val saveFavoritePokemonUseCase: SaveFavoritePokemonUseCase,
    private val deleteFavoritePokemonUseCase: DeleteFavoritePokemonUseCase,
    val mapper: PokemonCardMapperImpl
) : ViewModel() {

    private val _pokemon: MutableLiveData<PokemonCard> = MutableLiveData()
    val pokemon: LiveData<PokemonCard> = _pokemon

    fun setPokemon(pokemon: PokemonCard) {
        _pokemon.value = pokemon
    }

    suspend fun savePokemon(pokemon: PokemonCard) {
        saveFavoritePokemonUseCase.saveFavoritePokemon(mapper.mapCardToLocal(pokemon))
    }

    suspend fun deletePokemon(pokemon: PokemonCard) {
        deleteFavoritePokemonUseCase.deleteFavoritePokemon(mapper.mapCardToLocal(pokemon))
    }
}