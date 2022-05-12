package com.gaziev.pokemons.presentation.screens.view

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.LinearLayoutCompat
import com.gaziev.pokemons.R

class SearchToolbarView(
    context: Context,
    attrs: AttributeSet
) : LinearLayoutCompat(context, attrs) {

    val inputClose: ImageView
    val inputSearch: EditText

    init {
        val root = inflate(context, R.layout.view_search_toolbar, this)
        inputClose = root.findViewById(R.id.inputClose)
        inputSearch = root.findViewById(R.id.inputSearch)
    }



}