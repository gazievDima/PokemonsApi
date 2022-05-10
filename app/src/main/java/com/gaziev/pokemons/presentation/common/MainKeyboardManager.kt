package com.gaziev.pokemons.presentation.common

import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager

class MainKeyboardManager(
    private val imm: InputMethodManager?,
    private val root: ViewGroup,
) {

    fun up() {
        imm?.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )
    }

    fun down() {
        imm?.hideSoftInputFromWindow(root.windowToken, 0)
    }
}