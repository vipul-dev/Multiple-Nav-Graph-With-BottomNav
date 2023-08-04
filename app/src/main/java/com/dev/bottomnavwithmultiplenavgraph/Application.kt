package com.dev.bottomnavwithmultiplenavgraph

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi

const val CHANNEL_ID = "demoChannel"

class App : Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        val channel = NotificationChannel(CHANNEL_ID,"Bottom_Nav_With_Multiple_Nav",NotificationManager.IMPORTANCE_DEFAULT)

        (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(channel)


    }
}