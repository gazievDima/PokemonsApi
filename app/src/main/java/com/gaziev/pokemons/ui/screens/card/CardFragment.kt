package com.gaziev.pokemons.ui.screens.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gaziev.pokemons.databinding.FragmentCardBinding
import com.gaziev.pokemons.ui.common.fragments.BaseFragment

class CardFragment : BaseFragment<FragmentCardBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCardBinding = FragmentCardBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.close.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}