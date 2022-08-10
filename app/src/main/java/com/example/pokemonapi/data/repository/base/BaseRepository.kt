package com.example.pokemonapi.data.repository.base

import androidx.lifecycle.liveData
import com.example.pokemonapi.utils.Either
import kotlinx.coroutines.Dispatchers
import java.io.IOException

open class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = liveData(Dispatchers.IO) {
        try {
            emit(Either.Right(request()))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }
}