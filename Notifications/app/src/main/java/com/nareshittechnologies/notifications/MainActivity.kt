package com.nareshittechnologies.notifications

import android.app.Notification
import android.app.Notification.BigPictureStyle
import android.app.Notification.Builder
import android.app.Notification.FLAG_AUTO_CANCEL
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // TODO 1: Create a NotificationManager Object & Initalize it
    lateinit var notificationManager:NotificationManager
    // TODO 2: Create a NotificationChannel
    lateinit var notificationChannel: NotificationChannel
    lateinit var n:Notification

    companion object{
        val CHANNEL_ID = "my_noti_channel"
        val NOTIFICATION_ID = 23
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // You create a notification channel
            notificationChannel = NotificationChannel(CHANNEL_ID, "My Notification Channel", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel)
        }

        //TODO 4: You can bring the notifications alive
        // Pending intent is the description of the action to be performed on another component as if it is doing the
        // job on the current context.
        val pi:PendingIntent = PendingIntent.getActivity(this,123,
            Intent(applicationContext,MainActivity::class.java), FLAG_IMMUTABLE)

        // tODO 5: If you ever want to display an image in a notification, convert the image to bitmap format
        val b:Bitmap = BitmapFactory.decodeResource(resources,R.drawable.notif)

        // TODO 3: Build your notification to push it to users
        n = NotificationCompat.Builder(this, CHANNEL_ID)
            /*You write the entire build code here*/
            .setSmallIcon(R.drawable.baseline_beach_access_24)
            .setContentTitle("My Sample Notification")
            .setContentText("Anything you want to show on the message of a notification")
            .setContentIntent(pi)
            .addAction(R.drawable.baseline_beach_access_24,"Action 1",pi)
            .addAction(R.drawable.baseline_beach_access_24,"Action 2",pi)
            .addAction(R.drawable.baseline_beach_access_24,"Action 3",pi)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(b))
            /*.setStyle(NotificationCompat.BigTextStyle().bigText("---------adsfaksdmfalsdkfa----------------asdfjansdlfnasdklfmalskdfmaklsdmflk\nadskjfnalsdkfmalsdkmfalsdmflaksdmfklasdmflkadsmfklasdmflamdsklfmadslf\naksdjfnasldkfnals"))*/
            .setAutoCancel(true)
            .build()
    }

    fun sendNotification(view: View) {
        notificationManager.notify(NOTIFICATION_ID,n)
    }

    fun cancelNotification(view: View) {
        notificationManager.cancel(NOTIFICATION_ID)
    }
}