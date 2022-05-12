package com.gaziev.pokemons.presentation.screens.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.ViewCardFavoritePokemonBinding

class CardFavoritePokemonView(
    context: Context,
    attrs: AttributeSet
) : LinearLayoutCompat(context, attrs) {

    private val root: View by lazy { inflate(context, R.layout.view_card_favorite_pokemon, this) }
    private val binding: ViewCardFavoritePokemonBinding by lazy { ViewCardFavoritePokemonBinding.bind(root) }

    fun setCardImage(parent: ViewGroup, picture: String?) {
        picture?.let {
            Glide.with(parent).load(picture).fitCenter()
                .placeholder(R.drawable.loading).into(binding.cardImage)
        }
    }

    @SuppressLint("SetTextI18n")
    fun setFields(pokemon: PokemonLocalDetails, visibilityNumber: Int, number: Int?) {
        pokemon.let {
            with(binding) {
                tvNumber.visibility = visibilityNumber
                tvId.text = "id: ${it.id}"
                tvName.text = "name: ${it.name}"
                tvHp.text = "hp: ${it.hp}"

                number?.let {
                    tvNumber.text = "number: $number"
                }
            }
        }
    }

}