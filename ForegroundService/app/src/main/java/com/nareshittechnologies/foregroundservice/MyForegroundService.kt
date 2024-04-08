package com.nareshittechnologies.foregroundservice

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat

class MyForegroundService : Service() {

    lateinit var nm:NotificationManager
    lateinit var player:MediaPlayer

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer.create(this,R.raw.mysong)
    }

    override fun onBind(intent: Intent): IBinder {
        return null!!
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Logic to perform the foreground service.
        // We will send a notification

        if(intent?.action == "MYACTION"){
            nm.cancel(32)
            player.stop()
            stopSelf()
        }else{
            player.start()
            sendNotification()
        }

        return START_NOT_STICKY
    }

    fun sendNotification(){
        val channel = NotificationChannel("pavan","Service notification", NotificationManager.IMPORTANCE_HIGH)
        nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        nm.createNotificationChannel(channel)

        val n = NotificationCompat.Builder(this,"pavan")
            .setContentTitle("My Foreground Service is started")
            .setContentText("Hello")
            .setAutoCancel(true)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .build()

        nm.notify(32,n)

    }
}