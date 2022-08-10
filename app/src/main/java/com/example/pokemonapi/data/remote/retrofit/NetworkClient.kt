package com.example.pokemonapi.data.remote.retrofit

import com.example.pokemonapi.data.remote.apiservices.PokemonApiServices
import javax.inject.Inject

class NetworkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttp: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttp.provideOkHttpClient())

    fun provideCharacterApiService() = provideRetrofit.create(PokemonApiServices::class.java)
}
