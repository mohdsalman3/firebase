package com.example.library.repository

import android.util.Log
import com.example.library.base.BaseRepository
import com.example.library.base.Resource
import com.example.library.data.NotificationApiService
import com.example.library.data.modal.NotificationRequest
import com.example.library.data.modal.NotificationResponseData
import com.example.library.di.NotificationModule
import com.example.library.network.NetworkModule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NotificationRepository @Inject constructor(
):BaseRepository() {

    val apiService = NotificationModule.provideApiService(NetworkModule().getRetrofitInstance())

    fun postNotification(request: NotificationRequest):Flow<Resource<NotificationResponseData?>>{
        return flow {
            emit(Resource.Loading())
            val response= apiService.postNotificationRequest(request)
            emit(parseResponse(response))
        }.catch {
            emit(Resource.Error(throwable = Throwable(it)))
        }
    }
}