package com.clone.master

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder

class CloneService : Service() {
    
    override fun onCreate() {
        super.onCreate()
        _createNotificationChannel()
    }
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(NOTIFICATION_ID, _createNotification())
        return START_STICKY
    }
    
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    
    private fun _createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Clone Master Service",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }
    
    private fun _createNotification(): Notification {
        return Notification.Builder(this, CHANNEL_ID)
            .setContentTitle("Clone Master")
            .setContentText("Running")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .build()
    }
    
    companion object {
        private const val CHANNEL_ID = "clone_master_channel"
        private const val NOTIFICATION_ID = 1001
    }
}
