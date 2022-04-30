package com.gaziev.pokemons.presentation.screens.favorites.pager.common

import android.text.Editable
import android.text.TextWatcher
import com.gaziev.pokemons.presentation.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SearchTextWatcher(
    private val activity: MainActivity,
    private val lifecycleScope: CoroutineScope
) {
    private val stateFlow: MutableStateFlow<String> = MutableStateFlow("")

    fun setup(search: (text: String) -> Unit) {
        stateFlow.debounce(700)
            .onEach {
               search(it)
            }.launchIn(lifecycleScope)

        activity.binding.inputSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                stateFlow.value = text.toString()
            }
            override fun afterTextChanged(p0: Editable?) = Unit
        })
    }

}