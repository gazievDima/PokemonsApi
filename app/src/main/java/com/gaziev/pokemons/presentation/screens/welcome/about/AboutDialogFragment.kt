package com.gaziev.pokemons.presentation.screens.welcome.about

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.gaziev.pokemons.R

class AboutDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.about))
            .setMessage(getString(R.string.about_info))
            .setPositiveButton(getString(R.string.dialog_ok)) { _, _ -> }
            .create()
    }

}