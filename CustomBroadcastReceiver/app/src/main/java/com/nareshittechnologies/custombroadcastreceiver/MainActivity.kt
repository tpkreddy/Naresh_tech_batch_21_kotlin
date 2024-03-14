package com.nareshittechnologies.custombroadcastreceiver

import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter = IntentFilter()
        filter.addAction("com.nareshittechnologies.powerreceiver.CUSTOM_BROADCAST")

        registerReceiver(MyReceiver(),filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(MyReceiver())
    }
}