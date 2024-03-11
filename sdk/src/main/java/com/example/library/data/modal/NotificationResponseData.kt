package com.example.library.data.modal

import com.google.gson.annotations.SerializedName

data class NotificationResponseData(
    @field:SerializedName("appId")
    val appId: String,
    @field:SerializedName("identifier")
    val identifier: String,
    @field:SerializedName("token")
    val token: String,
    @field:SerializedName("platform")
    val platform: String
)
