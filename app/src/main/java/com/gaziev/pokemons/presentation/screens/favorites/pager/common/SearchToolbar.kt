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

    private val close: View = activity.binding.searchToolbarView.inputClose
    private val input: EditText = activity.binding.searchToolbarView.inputSearch
    private val buffer: String = activity.binding.toolbar.title.toString()

    init {
         close.setOnClickListener {
            modeOff()
        }
    }

    fun modeOn() {
        activity.binding.toolbar.title = EMPTY_FIELD
        close.visibility = View.VISIBLE
        input.visibility = View.VISIBLE
        input.requestFocus()
        activity.keyboardManager.up()
    }

    fun modeOff() {
        activity.binding.toolbar.title = buffer
        close.visibility = View.GONE
        input.visibility = View.GONE
        input.setText(EMPTY_FIELD)
        activity.keyboardManager.down()
    }

}