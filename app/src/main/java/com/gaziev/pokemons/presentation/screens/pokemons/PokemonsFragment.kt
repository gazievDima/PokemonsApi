package com.gaziev.pokemons.presentation.screens.pokemons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.pokemons.App
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.FragmentPokemonsBinding
import com.gaziev.pokemons.presentation.screens.common.BaseFragment
import com.gaziev.pokemons.presentation.screens.common.BottomNavigationFragment
import com.gaziev.pokemons.presentation.screens.common.ToolbarFragment
import com.gaziev.pokemons.presentation.screens.pokemons.list.PokemonsPagingAdapter
import com.gaziev.pokemons.presentation.screens.pokemons.list.PokemonsComparator
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonsFragment : BaseFragment<FragmentPokemonsBinding>(),
    BottomNavigationFragment,
    ToolbarFragment {

    override fun getName(): String = "List from Api"

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: PokemonsViewModel by viewModels { viewModelFactory }
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPokemonsBinding =
        FragmentPokemonsBinding::inflate
    private var pagingAdapter: PokemonsPagingAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as App).appComponent.inject(this)

        showShimmerLayout()
        initRecycler()
        pagingLoadListener()
        subscribe()
    }

    private fun initRecycler() {
        pagingAdapter = PokemonsPagingAdapter(PokemonsComparator) { pokemon: PokemonRemoteDetails ->
            val bundle = Bundle()
            bundle.putSerializable("info", pokemon)
            findNavController().navigate(R.id.cardFragment, bundle)
        }

        binding.pokemonsRecycler.layoutManager =
            GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        binding.pokemonsRecycler.adapter = pagingAdapter
    }

    private fun pagingLoadListener() {
        pagingAdapter?.addLoadStateListener { state ->
            if (state.refresh != LoadState.Loading) {
                hideShimmerLayout()
            }

            if (state.refresh is LoadState.Error) {
                showErrorLayout()
            }
        }
    }

    private fun subscribe() {
        viewModel.pokemons.observe(viewLifecycleOwner) { pagingData ->
            lifecycleScope.launch {
                pagingAdapter?.submitData(pagingData)
            }
        }
    }


    private fun showShimmerLayout() {
        binding.pokemonsRecycler.visibility = View.GONE
        binding.shimmerLayout.startShimmerAnimation()
    }

    private fun hideShimmerLayout() {
        binding.pokemonsRecycler.visibility = View.VISIBLE
        binding.shimmerLayout.stopShimmerAnimation()
        binding.shimmerLayout.visibility = View.GONE
    }

    private fun showErrorLayout() {
        Snackbar.make(
            binding.pokemonsRecycler,
            getString(R.string.check_your_internet_connection),
            Snackbar.LENGTH_LONG
        ).show()
        binding.screenError.splash.visibility = View.VISIBLE
        binding.shimmerLayout.visibility = View.GONE
    }

}


