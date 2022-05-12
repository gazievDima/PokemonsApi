package com.gaziev.pokemons.presentation.screens.favorites.pager.common

import android.view.View
import android.widget.EditText
import com.gaziev.pokemons.presentation.activity.MainActivity

class SearchToolbar(
    private val activity: MainActivity
) {
    companion object {
        const val EMPTY_FIELD = ""
    }

    private val close: View = activity.binding.inputClose
    private val input: EditText = activity.binding.inputSearch

    init {
         close.setOnClickListener {
            modeOff()
        }
    }

    fun modeOn() {
        close.visibility = View.VISIBLE
        input.visibility = View.VISIBLE
        input.requestFocus()
        activity.keyboardManager.up()
    }

    fun modeOff() {
        close.visibility = View.GONE
        input.visibility = View.GONE
        input.setText(EMPTY_FIELD)
        activity.keyboardManager.down()
    }

}