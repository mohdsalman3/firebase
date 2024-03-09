package com.example.library

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

internal const val TAG = "token"
abstract class PushFirebaseMessagingService:FirebaseMessagingService(){


    abstract fun onPushMessageReceived(message: RemoteMessage)
    abstract fun onNewFcmTokenReceived(token: String)

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d(TAG, "Notification received in Lib")

        if(message.data.isNotEmpty()){
            Log.d(TAG, "Message Data payload: " + message.data)
        }
        onPushMessageReceived(message)
    }

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")

        onNewFcmTokenReceived(token)
    }

}