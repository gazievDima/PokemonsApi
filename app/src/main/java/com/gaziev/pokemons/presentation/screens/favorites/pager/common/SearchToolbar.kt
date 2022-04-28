package com.gaziev.pokemons.presentation.screens.favorites.pager.common

import android.view.View
import android.widget.EditText
import com.gaziev.pokemons.presentation.common.MainActivity

class SearchToolbar(
    private val close: View,
    private val input: EditText,
    private val activity: MainActivity
) {

    init {
        close.setOnClickListener {
            modeOff()
        }
    }

    fun modeOn() {
        close.visibility = View.VISIBLE
        input.visibility = View.VISIBLE
        input.requestFocus()
        activity.showKeyboard()
    }

    fun modeOff() {
        close.visibility = View.GONE
        input.visibility = View.GONE
        input.setText("")
        activity.hideKeyboard()
    }
}