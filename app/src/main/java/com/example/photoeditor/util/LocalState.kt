package com.example.photoeditor.util

sealed class LocalState<out Any> {
    object NoState : LocalState<Nothing>()
    object Loading : LocalState<Nothing>()
    class Success<out T>(val data: T?) : LocalState<T>()
    object SuccessNoData : LocalState<Nothing>()
    class Error(t: Throwable) : LocalState<Nothing>()

}