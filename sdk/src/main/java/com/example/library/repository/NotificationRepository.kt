package com.example.library.repository

import com.example.library.base.BaseRepository
import com.example.library.base.Resource
import com.example.library.data.NotificationApiService
import com.example.library.data.modal.NotificationRequest
import com.example.library.data.modal.NotificationResponseData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NotificationRepository @Inject constructor(
    val apiService: NotificationApiService
):BaseRepository() {
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