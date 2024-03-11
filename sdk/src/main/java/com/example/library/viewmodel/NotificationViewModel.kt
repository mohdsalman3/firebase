package com.example.library.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.library.base.BaseViewModel
import com.example.library.base.Resource
import com.example.library.data.modal.NotificationRequest
import com.example.library.data.modal.NotificationResponseData
import com.example.library.repository.NotificationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NotificationViewModel @Inject constructor(
    private val repository: NotificationRepository
):BaseViewModel() {
    val successResponse = MutableLiveData<ArrayList<NotificationResponseData?>>()
    fun postNotification(request: NotificationRequest){
        viewModelScope.launch(Dispatchers.IO) {
            repository.postNotification(request).collect {
                when (it) {
                    is Resource.Loading -> {
                        loading.postValue(true)
                    }

                    is Resource.Error -> {
                        loading.postValue(false)
                        errorMessage.postValue(it.throwable)
                    }

                    is Resource.Success -> {
                        loading.postValue(false)
                        val response = it.data
                    }
                }
            }
        }
    }

}