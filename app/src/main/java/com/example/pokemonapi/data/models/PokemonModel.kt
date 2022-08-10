package com.example.pokemonapi.data.models

import com.google.gson.annotations.SerializedName

data class PokemonModel(
    @SerializedName("name")
    val name: String,
    )
