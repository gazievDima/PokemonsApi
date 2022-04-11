package com.gaziev.pokemons.ui.screens.favorites.pager.common

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import com.gaziev.pokemons.ui.MainActivity

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

        input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
            override fun afterTextChanged(p0: Editable?) = Unit
            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    Log.i("TAGS", "s: ${s.toString()}, start: $start, count: $count, after: $after")
                if(s.toString() == "0")
                    modeOff()
            }
        })
    }

    fun modeOff() {
        close.visibility = View.GONE
        input.visibility = View.GONE
        input.setText("")
        activity.hideKeyboard()
    }
}