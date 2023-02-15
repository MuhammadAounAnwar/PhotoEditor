package com.example.photoeditor.network

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null,
    val error: RetrofitError? = null,
    val code: String? = null,
    val status: String? = null
) {
    class Success<T>(data: T) : NetworkResult<T>(data)
    class Error<T>(message: String? = null, data: T? = null, error: RetrofitError?) :
        NetworkResult<T>(data, message, error)

//    class Loading<T> : NetworkResult<T>()
}
