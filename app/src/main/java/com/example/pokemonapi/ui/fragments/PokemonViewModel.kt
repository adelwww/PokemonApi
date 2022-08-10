package com.example.pokemonapi.ui.fragments

import com.example.pokemonapi.data.repository.PokemonRepository
import com.example.pokemonapi.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository
) : BaseViewModel() {

    fun fetchPokemon() = repository.fetchPokemon()
}