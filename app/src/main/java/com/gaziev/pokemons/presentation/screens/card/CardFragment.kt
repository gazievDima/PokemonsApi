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
import com.gaziev.pokemons.App
import com.gaziev.pokemons.R
import com.gaziev.pokemons.databinding.FragmentCardBinding
import com.gaziev.pokemons.presentation.screens.common.BaseFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import javax.inject.Inject

class CardFragment : BaseFragment<FragmentCardBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: CardViewModel by viewModels { viewModelFactory }
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCardBinding =
        FragmentCardBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as App).appComponent.inject(this)

        if (savedInstanceState == null) {
            val pokemon = arguments?.getSerializable("info")

            pokemon?.let {
                viewModel.setPokemon(it) { liked: Boolean? ->
                    liked?.let { changeColorLikeButton(liked) }
                }
            }
        }

        subscribe()
        clickListeners()
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
            lifecycleScope.launch {

                viewModel.setLikeState() { likeState, name ->
                    changeColorLikeButton(likeState)
                    val status = if (likeState) "saved" else "deleted"
                    Snackbar.make(binding.cardImage, "$name is $status.",
                        Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun changeColorLikeButton(liked: Boolean) {
        val color = if (liked) R.color.light_red else R.color.grey

        ImageViewCompat.setImageTintList(
            binding.like,
            ColorStateList.valueOf(ContextCompat.getColor(requireContext(), color))
        )
    }

}

