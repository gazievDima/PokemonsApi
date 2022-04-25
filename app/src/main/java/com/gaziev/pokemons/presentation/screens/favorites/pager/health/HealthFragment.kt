package com.gaziev.pokemons.presentation.screens.favorites.pager.health

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonLocal
import com.gaziev.pokemons.App
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.PagerFavoritesHealthBinding
import com.gaziev.pokemons.presentation.MainActivity
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.PagerBaseFragment
import com.gaziev.pokemons.presentation.screens.favorites.pager.common.SearchToolbar
import com.gaziev.pokemons.presentation.screens.favorites.pager.health.list.HealthAdapter
import javax.inject.Inject

class HealthFragment : PagerBaseFragment<PagerFavoritesHealthBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> PagerFavoritesHealthBinding =
        PagerFavoritesHealthBinding::inflate
    private var searchToolbar: SearchToolbar? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: HealthViewModel by lazy { ViewModelProvider(this, viewModelFactory)[HealthViewModel::class.java] }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as App).daggerAppComponent.inject(this)

        viewModel.pokemons.observe(viewLifecycleOwner) { list: List<PokemonLocal>? ->
            list?.let {
                binding.favoritesRecycler.layoutManager =
                    GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
                binding.favoritesRecycler.adapter = HealthAdapter(list) { pokemon: PokemonLocal ->
                    val bundle = Bundle()
                    bundle.putSerializable("info", pokemon)
                    findNavController().navigate(R.id.cardFragment, bundle)
                }
            }
        }

        searchToolbar = SearchToolbar(
            (activity as MainActivity).binding.inputClose,
            (activity as MainActivity).binding.inputSearch,
            (activity as MainActivity)
        )

        (activity as MainActivity).binding.inputSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.search(text.toString())
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