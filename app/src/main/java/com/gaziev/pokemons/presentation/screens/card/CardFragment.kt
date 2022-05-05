package com.gaziev.pokemons.presentation.screens.card

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.gaziev.domain.models.PokemonRemoteDetails
import com.gaziev.domain.models.PokemonLocalDetails
import com.gaziev.pokemons.App
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.FragmentCardBinding
import com.gaziev.pokemons.presentation.common.BaseFragment
import com.gaziev.pokemons.presentation.screens.card.model.PokemonCardMapperImpl
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import javax.inject.Inject

class CardFragment : BaseFragment<FragmentCardBinding>() {

    @Inject
    lateinit var mapper: PokemonCardMapperImpl
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: CardViewModel by viewModels { viewModelFactory }
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCardBinding =
        FragmentCardBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as App).appComponent.inject(this)


        if (savedInstanceState == null) {
            arguments?.getSerializable("info")?.apply {
                if (this is PokemonLocalDetails) {
                    val pokemon = mapper.mapLocalToCard(this)
                    viewModel.setPokemon(pokemon)
                    changeLike(pokemon.liked)
                }
                if (this is PokemonRemoteDetails) {
                    val pokemon = mapper.mapRemoteToCard(this)
                    viewModel.setPokemon(pokemon)
                    changeLike(pokemon.liked)
                }
            }
        }

        subscribe()
        clickListeners()

    }

    private fun changeLike(flag: Boolean) {
        if (flag)
            ImageViewCompat.setImageTintList(
                binding.like,
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.light_red))
            )
        else
            ImageViewCompat.setImageTintList(
                binding.like,
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.grey))
            )
    }

    @SuppressLint("SetTextI18n")
    private fun subscribe() {
        viewModel.pokemon.observe(viewLifecycleOwner) {

            with(binding) {
                tvId.text = "Id: ${it.id ?: "..."}"
                tvName.text = "Name: ${it.name ?: "..."}"
                tvSupertype.text = "Supertype: ${it.supertype ?: "..."}"
                tvSubtypes.text = "Subtypes: ${it.supertype ?: "..."}"
                tvHp.text = "Hp: ${it.hp ?: "..."}"
                tvTypes.text = "Types: ${it.types ?: "..."}"
                tvEvolvesTo.text = "Evolves: ${it.evolvesTo ?: "..."}"
                tvRules.text = "Rules: ${it.rules ?: "..."}"
                tvArtist.text = "Artist: ${it.artist ?: "..."}"
                tvRarity.text = "Rarity: ${it.rarity ?: "..."}"

                Glide
                    .with(this@CardFragment)
                    .load(it.images?.small)
                    .centerCrop()
                    .placeholder(R.drawable.loading)
                    .into(cardImage)
            }
        }
    }

    private fun clickListeners() {
        binding.close.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.like.setOnClickListener {
            if (viewModel.pokemon.value?.liked!!) {
                lifecycleScope.launch {
                    viewModel.pokemon.value?.liked = false
                    changeLike(viewModel.pokemon.value?.liked!!)
                    viewModel.deletePokemon(viewModel.pokemon.value!!)
                    Snackbar.make(
                        binding.cardImage,
                        "pokemon name: ${viewModel.pokemon.value?.name} is deleted.",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            } else {
                lifecycleScope.launch {
                    viewModel.pokemon.value?.liked = true
                    changeLike(viewModel.pokemon.value?.liked!!)
                    viewModel.savePokemon(viewModel.pokemon.value!!)
                    Snackbar.make(
                        binding.cardImage,
                        "pokemon name: ${viewModel.pokemon.value?.name} is saved.",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

}

