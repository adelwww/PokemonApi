package com.example.pokemonapi.data.models

import com.google.gson.annotations.SerializedName

data class ResponseModel<T>(
    @SerializedName("results")
    val results: List<T>
)