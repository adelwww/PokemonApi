package com.example.pokemonapi.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pokemonapi.R
import com.example.pokemonapi.databinding.FragmentPokemonBinding
import com.example.pokemonapi.ui.adapters.PokemonAdapter
import com.example.pokemonapi.ui.base.BaseFragment
import com.example.pokemonapi.utils.Either
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonFragment : BaseFragment<PokemonViewModel, FragmentPokemonBinding>(
    R.layout.fragment_pokemon
) {
    override val viewModel: PokemonViewModel by viewModels()
    override val binding by viewBinding(FragmentPokemonBinding::bind)
    private val pokemonAdapter = PokemonAdapter()

    override fun initialize() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding.recycler) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = pokemonAdapter
    }

    override fun setupSubscribe() {
        viewModel.fetchPokemon().observe(viewLifecycleOwner){
            when(it){
                is Either.Left -> {
                    Log.e("son",it.value)
                }
                is Either.Right -> {
                    Log.e("son",it.value.toString())
                    pokemonAdapter.submitList(it.value.results)
                }
            }
        }
    }
}