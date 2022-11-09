package tech.henriquedev.notificationapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createChannel(CHANNEL_ID, CHANNEL_NAME)

        val button = findViewById<Button>(R.id.button_show_notification)
        button.setOnClickListener {
            val notificationManager = getNotificationManager()
            notificationManager.sendNotification(applicationContext, "Hello", "This is a notification")
        }
    }

    private fun createChannel(channelId: String, channelName: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )

            notificationChannel.run {
                enableLights(true)
                lightColor = Color.BLUE
                enableVibration(true)
                description = "Description channel test"
            }

            val notificationManager = getNotificationManager()
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

    private fun getNotificationManager() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
}