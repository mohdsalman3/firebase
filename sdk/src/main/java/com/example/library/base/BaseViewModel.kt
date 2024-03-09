package com.example.library.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel:ViewModel() {
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<Throwable>()
    val successMessage = MutableLiveData<String>()

}