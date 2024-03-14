package com.nareshittechnologies.custombroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val s:String? = intent.getStringExtra("CUSTOM")
        Toast.makeText(context,s,Toast.LENGTH_LONG).show()
    }
}