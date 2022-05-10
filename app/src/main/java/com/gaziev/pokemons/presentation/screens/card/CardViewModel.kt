package com.gaziev.pokemons.presentation.screens.card

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.gaziev.data.mapper.pokemon.PokemonRemoteLocalMapperImpl
import com.gaziev.data.models.PokemonLocalEntity
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.usecases.delete.DeleteFavoritePokemonUseCase
import com.gaziev.domain.usecases.save.SaveFavoritePokemonUseCase
import com.gaziev.domain.usecases.search.SearchFavoritePokemonUseCase
import com.gaziev.pokemons.presentation.screens.card.model.PokemonCard
import com.gaziev.pokemons.presentation.screens.card.model.PokemonCardMapperImpl
import com.gaziev.pokemons.presentation.screens.card.model.PokemonMapper
import kotlinx.coroutines.launch
import java.io.Serializable
import javax.inject.Inject

class CardViewModel @Inject constructor(
    private val saveFavoritePokemonUseCase: SaveFavoritePokemonUseCase,
    private val deleteFavoritePokemonUseCase: DeleteFavoritePokemonUseCase,
    private val searchFavoritePokemonUseCase: SearchFavoritePokemonUseCase,
    private val mapperCard: PokemonCardMapperImpl,
    private val mapperRemoteLocalDetails: PokemonRemoteLocalMapperImpl
) : ViewModel() {

    private val _pokemon: MutableLiveData<PokemonCard> = MutableLiveData()
    val pokemon: LiveData<PokemonCard> = _pokemon

    fun setPokemon(pokemon: Serializable, icon: (liked: Boolean?) -> Unit) {
        viewModelScope.launch {

            val pokemonCard = if (pokemon is PokemonLocalDetails)
                openLocalPokemon(pokemon)
            else
                openOtherPokemon(pokemon)

            _pokemon.value = pokemonCard
            icon(pokemonCard.liked)
        }
    }

    suspend fun savePokemonToDataBase(pokemon: PokemonCard) {
        saveFavoritePokemonUseCase.saveFavoritePokemon(mapperCard.mapCardToLocal(pokemon))
    }

    suspend fun deletePokemonFromDataBase(idPokemon: String?) {
        idPokemon?.let {
            deleteFavoritePokemonUseCase.deleteFavoritePokemon(idPokemon)
        }
    }

    private suspend fun openOtherPokemon(o: Serializable): PokemonCard {
        return if (checkExistsPokemonFromDataBase(o as PokemonRemoteDetails)) {
            openLocalPokemon(o)
        } else {
            openRemotePokemon(o)
        }
    }

    private fun openLocalPokemon(o: Serializable): PokemonCard {
        val pokemon = if (o is PokemonRemoteDetails) {
            mapperRemoteLocalDetails.mapTo(o)
        } else {
            o as PokemonLocalDetails
        }
        return mapperCard.mapLocalToCard(pokemon)
    }

    private fun openRemotePokemon(o: Serializable): PokemonCard {
        return mapperCard.mapRemoteToCard(o as PokemonRemoteDetails)
    }

    private suspend fun checkExistsPokemonFromDataBase(pokemon: PokemonRemoteDetails): Boolean {
        return if (pokemon.id != null)
            searchFavoritePokemonUseCase.searchFavoritePokemon(pokemon.id!!)
        else false
    }

    suspend fun setLikeState(lambda: (likeState: Boolean, name: String?) -> Unit) {
        viewModelScope.launch {
            pokemon.value?.let { pokemon ->

                if(pokemon.liked) {
                    deletePokemonFromDataBase(pokemon.id)
                } else {
                    savePokemonToDataBase(pokemon)
                }
                pokemon.liked = !pokemon.liked
                lambda(pokemon.liked, pokemon.name)
            }
        }
    }

}