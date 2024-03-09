package com.example.library.base

sealed class Resource<out T>{
    /** This is use to show and hide loading */
    data class Loading(val msg: String? = null) : Resource<Nothing>()

    /** This is use to send success */
    data class Success<T>(val data: T, val message: String? = null) : Resource<T>()

    /** This is use to send Error */
    data class Error<T>(
        val data: ApiErrorResponse? = null, val message: String? = null, val throwable: Throwable? = null,
        val responseCode: Int? = 0, val serverErrorCode: String? = null
    ) : Resource<T>()
}