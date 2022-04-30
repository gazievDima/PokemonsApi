package com.gaziev.pokemons.presentation.screens.favorites.pager.common

import android.view.View
import android.widget.EditText
import com.gaziev.pokemons.presentation.MainActivity

class SearchToolbar(
    private val activity: MainActivity
) {
    private var close: View? = null
    private var input: EditText? = null

    init {
        close = activity.binding.inputClose
        input = activity.binding.inputSearch

        close?.setOnClickListener {
            modeOff()
        }
    }

    fun modeOn() {
        close?.visibility = View.VISIBLE
        input?.visibility = View.VISIBLE
        input?.requestFocus()
        activity.keyboardManager.up()
    }

    fun modeOff() {
        close?.visibility = View.GONE
        input?.visibility = View.GONE
        input?.setText("")
        activity.keyboardManager.down()
    }
}