package com.nareshittechnologies.workmanager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWork(val context:Context, workerParameters: WorkerParameters): Worker(context, workerParameters) {

    override fun doWork(): Result {
        val manager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel("pavan","My Hydration Remainder", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
        }

        val notification: Notification = NotificationCompat.Builder(context,"pavan")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Drink a Glass of Water")
            .setContentText("Be Hydrated all the time to save your health from ailments")
            .setAutoCancel(true)
            .build()

        manager.notify(22,notification)

        return Result.success()
    }
}