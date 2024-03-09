package com.example.library.base

import com.google.gson.annotations.SerializedName

data class ApiErrorResponse(
    @SerializedName("error")
    val error: String?,
    @SerializedName("errorCode")
    val errorCode: String?,
    @SerializedName("message")
    val message: String?
)
