package com.gaziev.pokemons.presentation.screens.card

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.usecases.delete.DeleteFavoritePokemonUseCase
import com.gaziev.domain.usecases.save.SaveFavoritePokemonUseCase
import com.gaziev.domain.usecases.search.SearchFavoritePokemonUseCase
import com.gaziev.pokemons.presentation.screens.card.model.PokemonCard
import com.gaziev.pokemons.presentation.screens.card.model.PokemonCardMapperImpl
import com.gaziev.pokemons.presentation.screens.card.model.PokemonMapper
import java.io.Serializable
import javax.inject.Inject

class CardViewModel @Inject constructor(
    private val saveFavoritePokemonUseCase: SaveFavoritePokemonUseCase,
    private val deleteFavoritePokemonUseCase: DeleteFavoritePokemonUseCase,
    private val searchFavoritePokemonUseCase: SearchFavoritePokemonUseCase,
    private val mapper: PokemonCardMapperImpl,
) : ViewModel() {

    private val _pokemon: MutableLiveData<PokemonCard> = MutableLiveData()
    val pokemon: LiveData<PokemonCard> = _pokemon

    fun setPokemon(pokemon: PokemonCard) {
        _pokemon.value = pokemon
    }

    suspend fun savePokemonToDataBase(pokemon: PokemonCard) {
        saveFavoritePokemonUseCase.saveFavoritePokemon(mapper.mapCardToLocal(pokemon))
    }

    suspend fun deletePokemonFromDataBase(idPokemon: String) {
        deleteFavoritePokemonUseCase.deleteFavoritePokemon(idPokemon)
    }

    suspend fun checkExistsPokemonFromDataBase(pokemon: PokemonRemoteDetails): Boolean {
        return if (pokemon.id != null)
            searchFavoritePokemonUseCase.searchFavoritePokemon(pokemon.id!!)
        else false
    }
}