package tech.henriquedev.notificationapp

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

// A partir no Android 8 API 26 necessario passar o Channel ID
const val CHANNEL_ID = "app_channel"
const val CHANNEL_NAME = "Channel App"
const val NOTIFICATION_ID = 0

fun NotificationManager.sendNotification(appContext: Context, title: String, message: String) {
    val builder = NotificationCompat.Builder(appContext, CHANNEL_ID)

    builder
        .setSmallIcon(R.drawable.ic_notification)
        .setContentTitle(title)
        .setContentText(message)
        .priority = NotificationCompat.PRIORITY_DEFAULT

    notify(NOTIFICATION_ID, builder.build())
}