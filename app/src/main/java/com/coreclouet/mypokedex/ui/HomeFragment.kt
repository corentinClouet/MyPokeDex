package com.coreclouet.mypokedex.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.coreclouet.mypokedex.R
import com.coreclouet.mypokedex.databinding.HomeFragmentBinding
import com.coreclouet.mypokedex.viewmodel.HomeFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null
    private val viewModel: HomeFragmentViewModel by viewModel()

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding?.root ?: inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.cvPokedex?.setOnClickListener {
/*            val action = HomeFragmentDirections.actionHomeFragmentToPokedexFragment()
            it.findNavController().navigate(action)*/
            viewModel.getVersions()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}