package com.example.pokemonapi.data.remote.apiservices

import com.example.pokemonapi.data.models.PokemonModel
import retrofit2.http.GET

interface PokemonApiServices {

    @GET("pokemon")
    suspend fun fetchPokemon(): List<PokemonModel>
}