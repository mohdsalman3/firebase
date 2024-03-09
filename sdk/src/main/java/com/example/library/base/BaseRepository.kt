package com.example.library.base

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response

open class BaseRepository {
    fun <T> parseResponse(response: Response<T>): Resource<T?> {
        return if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body())
        } else {
            val error: ApiErrorResponse? = response.parseErrorResponse()
            Resource.Error(
                data = error,
                throwable = Exception(response.message()),
                responseCode = response.code()


            )
        }

    }

    fun <T> Response<*>.parseErrorResponse(): T? {
        val gson = Gson()
        val type = object : TypeToken<ApiErrorResponse>() {}.type
        return try {
            gson.fromJson(errorBody()?.charStream(), type)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
