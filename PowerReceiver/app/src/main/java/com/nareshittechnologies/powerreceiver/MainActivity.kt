package com.nareshittechnologies.powerreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var iv:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv = findViewById(R.id.imageView)

        val filter:IntentFilter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)

        registerReceiver(PowerReceiverBroadcast(iv),filter)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(PowerReceiverBroadcast(iv))
    }
    // TODO 1: create two images that represents battery charging mode and battery draining mode.
    // TODO 2: Create an imageview on activity_main.xml and connect to MainActivity.kt
    /*
    * What ever the number of braodcasts you want to listen to...
    * put all of them in an intentfilter object and then go for the registration of
    * listening to those broadcasts*/
    // TODO 3: refer above comment
    // TODO 4: Register the broadcast to listen to the actions (Broadcasts)
        // TODO 4.1 : First create a broadcast Receiver in the app
        // TODO 4.2: Use registerReceiver(...) method to register your broadcast
    // TODO 5: unregister your broadcast (to avoid unncessary battery drain)

}