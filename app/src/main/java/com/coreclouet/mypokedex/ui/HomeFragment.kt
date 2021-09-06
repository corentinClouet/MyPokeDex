package com.coreclouet.mypokedex.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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
        initObservers()
        return binding?.root ?: inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuListeners()
    }

    private fun initObservers() {
        viewModel.versions.observe(viewLifecycleOwner, Observer { versions ->
            context?.let { ctx ->
                val adapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_item, versions.map { it.name })
                // Set layout to use when the list of choices appear
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Set Adapter to Spinner
                binding?.spVersions?.adapter = adapter
            }
        })
    }

    private fun initMenuListeners() {
        binding?.cvPokedex?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToPokedexFragment()
            it.findNavController().navigate(action)
        }
        binding?.cvItems?.setOnClickListener {
            Toast.makeText(context, "Not implemented yet", Toast.LENGTH_SHORT).show()
        }
        binding?.cvMoves?.setOnClickListener {
            Toast.makeText(context, "Not implemented yet", Toast.LENGTH_SHORT).show()
        }
        binding?.cvTypes?.setOnClickListener {
            Toast.makeText(context, "Not implemented yet", Toast.LENGTH_SHORT).show()
        }
        binding?.cvFavorites?.setOnClickListener {
            Toast.makeText(context, "Not implemented yet", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fillVersionsSpinner() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}