package com.coreclouet.mypokedex.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.coreclouet.mypokedex.R
import com.coreclouet.mypokedex.viewmodel.PokemonFragmentViewModel

class PokemonFragment : Fragment() {

    companion object {
        fun newInstance() = PokemonFragment()
    }

    private lateinit var viewModel: PokemonFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pokemon_fragment, container, false)
    }

}