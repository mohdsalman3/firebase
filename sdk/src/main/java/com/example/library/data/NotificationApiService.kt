package com.example.library.data

import com.example.library.data.modal.NotificationRequest
import com.example.library.data.modal.NotificationResponseData
import com.example.library.network.SAVE_FCM_TOKEN
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NotificationApiService {

    @POST(SAVE_FCM_TOKEN)
    suspend fun postNotificationRequest(@Body request:NotificationRequest):Response<NotificationResponseData>
}