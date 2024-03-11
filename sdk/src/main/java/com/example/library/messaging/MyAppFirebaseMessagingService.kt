package com.example.library.messaging

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.util.Log
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.app.NotificationCompat
import com.example.library.PushClient
import com.example.library.PushFirebaseMessagingService
import com.example.library.R
import com.google.firebase.messaging.RemoteMessage


internal const val CHANNEL_ID="com.example.pushlibandroid.Channel_Id"

/**
 *  Created by ankur.khandelwal on 08/03/24
 *
 */
class MyAppFirebaseMessagingService : PushFirebaseMessagingService() {

    override fun onPushMessageReceived(message: RemoteMessage) {
        sendNotification(message.notification?.title, message.notification?.body)

    }

    override fun onNewFcmTokenReceived(token: String) {

    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    private fun sendNotification(messageBody: String?, title: String?) {
        Log.d("Ankur","${PushClient.getConfigForSdk().toString()}")
        val channelId = CHANNEL_ID
        val notificationBuilder: NotificationCompat.Builder =
            NotificationCompat.Builder(this, channelId)
                .setContentTitle(title)
                .setContentText(messageBody).setColor(PushClient.getConfigForSdk()?.defaultNotificationColor?:
                R.color.notification_default_color)
                .setSmallIcon(PushClient.getConfigForSdk()?.notificationIcon?:
                R.drawable.ring_notification_svgrepo_com)
                .setAutoCancel(true)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // Since android Oreo notification channel is needed.
        val channel = NotificationChannel(
            channelId,
            "Default Channel",
            NotificationManager.IMPORTANCE_HIGH
        )
        notificationManager.createNotificationChannel(channel)
        notificationManager.notify(0 , notificationBuilder.build())
    }
}