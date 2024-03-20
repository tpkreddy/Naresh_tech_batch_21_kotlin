package com.nareshittechnologies.alarmmanager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class HydrationReceiver : BroadcastReceiver() {

    // TODO Creating this receiver because when the alarm triggers this receiver will be called
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast
        val manager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel("pavan","My Hydration Remainder", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
        }

        val notification:Notification = NotificationCompat.Builder(context,"pavan")
            .setSmallIcon(R.drawable.baseline_water_drop_24)
            .setContentTitle("Drink a Glass of Water")
            .setContentText("Be Hydrated all the time to save your health from ailments")
            .setAutoCancel(true)
            .build()

        manager.notify(22,notification)
    }
}