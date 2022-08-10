package com.example.pokemonapi.data.repository

import com.example.pokemonapi.data.remote.apiservices.PokemonApiServices
import com.example.pokemonapi.data.repository.base.BaseRepository
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val apiServices: PokemonApiServices
) : BaseRepository() {

    fun fetchPokemon() = doRequest { apiServices.fetchPokemon() }
}