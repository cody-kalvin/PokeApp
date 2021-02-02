package com.cody.pokeapp.api

sealed class RequestState<out T: Any>{
    object Initial: RequestState<Nothing>()
    object Loading: RequestState<Nothing>()
    class Success<T: Any>(val response: T): RequestState<T>()
    class Failure(val error: String): RequestState<Nothing>()
}