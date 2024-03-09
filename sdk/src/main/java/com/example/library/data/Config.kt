package com.example.library.data

import android.graphics.drawable.Drawable
import com.example.library.R

/**
 *  Created by ankur.khandelwal on 08/03/24
 *
 */
data class Config(val configKey: String, val notificationIcon: Int? = R.drawable.ring_notification_svgrepo_com,
                  val defaultNotificationColor: Int? = R.color.notification_default_color, val env: Env = Env.DEV)