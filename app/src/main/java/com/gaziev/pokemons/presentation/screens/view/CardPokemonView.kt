package com.gaziev.pokemons.presentation.screens.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.gaziev.pokemons.R
import com.gaziev.pokemons.presentation.screens.card.model.PokemonCard

class CardPokemonView(context: Context, attrs: AttributeSet) : LinearLayoutCompat(context, attrs) {

    private val cardImage: ImageView
    private val tvId: TextView
    private val tvName: TextView
    private val tvSupertype: TextView
    private val tvSubtypes: TextView
    private val tvHp: TextView
    private val tvTypes: TextView
    private val tvEvolvesTo: TextView
    private val tvRules: TextView
    private val tvArtist: TextView
    private val tvRarity: TextView

    init {
        val root = inflate(context, R.layout.view_card_pokemon, this)
        cardImage = root.findViewById(R.id.cardImage)
        tvId = root.findViewById(R.id.tvId)
        tvName = root.findViewById(R.id.tvName)
        tvSupertype = root.findViewById(R.id.tvSupertype)
        tvSubtypes = root.findViewById(R.id.tvSubtypes)
        tvHp = root.findViewById(R.id.tvHp)
        tvTypes = root.findViewById(R.id.tvTypes)
        tvEvolvesTo = root.findViewById(R.id.tvEvolvesTo)
        tvRules = root.findViewById(R.id.tvRules)
        tvArtist = root.findViewById(R.id.tvArtist)
        tvRarity = root.findViewById(R.id.tvRarity)
    }

    fun setCardImage(fragment: Fragment, picture: String?) {
        picture?.let {
            Glide
                .with(fragment)
                .load(picture)
                .centerCrop()
                .placeholder(R.drawable.loading)
                .into(cardImage)
        }
    }

    @SuppressLint("SetTextI18n")
    fun setFields(pokemon: PokemonCard) {
        pokemon.let {
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