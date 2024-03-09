package com.example.pushlibandroid

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

/**
 *  Created by ankur.khandelwal on 08/03/24
 *
 */
@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }

}