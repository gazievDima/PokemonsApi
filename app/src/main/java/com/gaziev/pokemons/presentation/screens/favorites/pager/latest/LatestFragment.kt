package com.gaziev.pokemons.presentation.screens.favorites.pager.latest

import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.pokemons.App
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.PagerFavoritesLatestBinding
import com.gaziev.pokemons.presentation.common.MainActivity
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.PagerBaseFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.SearchToolbar
import com.gaziev.pokemons.presentation.screens.favorites.pager.health.list.HealthAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class LatestFragment : PagerBaseFragment<PagerFavoritesLatestBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> PagerFavoritesLatestBinding =
        PagerFavoritesLatestBinding::inflate
    private var searchToolbar: SearchToolbar? = null
    private val stateFlow: MutableStateFlow<String> = MutableStateFlow("")

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: LatestViewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[LatestViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as App).daggerAppComponent.inject(this)

        viewModel.pokemons.observe(viewLifecycleOwner) { list ->

            binding.favoritesRecycler.layoutManager =
                GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
            binding.favoritesRecycler.adapter =
                HealthAdapter(list) { pokemon: PokemonLocalDetails ->
                    val bundle = Bundle()
                    bundle.putSerializable("info", pokemon)
                    findNavController().navigate(R.id.cardFragment, bundle)
                }
        }

        searchToolbar = SearchToolbar(
            (activity as MainActivity).binding.inputClose,
            (activity as MainActivity).binding.inputSearch,
            (activity as MainActivity)
        )

        stateFlow.debounce(700)
            .onEach {
                Log.e(TAG, "result -> $it")
                viewModel.search(it)
            }.launchIn(lifecycleScope)

        (activity as MainActivity).binding.inputSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                stateFlow.value = text.toString()
            }
            override fun afterTextChanged(p0: Editable?) = Unit
        })
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    searchToolbar?.modeOn()
                    true
                }
                R.id.sort -> {
                    Log.i(TAG, "sort button")
                    viewModel.sortItems()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        searchToolbar?.modeOff()
        viewModel.endSearch()
    }

}
