package com.gaziev.pokemons.presentation.screens.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.ViewCardPokemonBinding
import com.gaziev.pokemons.presentation.screens.card.model.PokemonCard

class CardPokemonView(context: Context, attrs: AttributeSet) : LinearLayoutCompat(context, attrs) {

    private val root: View by lazy { inflate(context, R.layout.view_card_pokemon, this) }
    private val binding: ViewCardPokemonBinding by lazy { ViewCardPokemonBinding.bind(root) }

    fun setCardImage(fragment: Fragment, picture: String?) {
        picture?.let {
            Glide
                .with(fragment)
                .load(picture)
                .centerCrop()
                .placeholder(R.drawable.loading)
                .into(binding.cardImage)
        }
    }

    @SuppressLint("SetTextI18n")
    fun setFields(pokemon: PokemonCard) {
        pokemon.let {
            with(binding) {
                tvId.text = "Id: ${it.id ?: "..."}"
                tvName.text = "Name: ${it.name ?: "..."}"
                tvSupertype.text = "Supertype: ${it.supertype ?: "..."}"
                tvSubtypes.text = "Subtypes: ${it.supertype ?: "..."}"
                tvHp.text = "Hp: ${it.hp ?: "..."}"
                tvTypes.text = "Types: ${it.types ?: "..."}"
                tvEvolvesTo.text = "Evolves: ${it.evolvesTo ?: "..."}"
                tvRules.text = "Rules: ${it.rules ?: "..."}"
                tvArtist.text = "Artist: ${it.artist ?: "..."}"
                tvRarity.text = "Rarity: ${it.rarity ?: "..."}"
            }
        }
    }

}