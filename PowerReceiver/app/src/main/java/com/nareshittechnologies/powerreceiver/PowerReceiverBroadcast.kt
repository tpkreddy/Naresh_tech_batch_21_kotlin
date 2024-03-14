package com.nareshittechnologies.powerreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.Toast

class PowerReceiverBroadcast(val iv:ImageView) : BroadcastReceiver() {

    /**
     * This function is called whenever the registered actions (Broadcasts) are released in the
     * system (Android Os)*/

    companion object{
        val CUSTOM_BROADCAST:String = "com.nareshittechnologies.powerreceiver.CUSTOM_BROADCAST"
    }

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if(intent.action == Intent.ACTION_POWER_CONNECTED){
            // whatever has to be done when the charger is connected, we write it here
            iv.setImageResource(R.drawable.baseline_battery_charging_full_24)
        }else if(intent.action == Intent.ACTION_POWER_DISCONNECTED){
            // logic here
            iv.setImageResource(R.drawable.baseline_battery_alert_24)
        }else if(intent.action == CUSTOM_BROADCAST){
            val s:String? = intent.getStringExtra("CUSTOM");
            Toast.makeText(context,"Custom Broadcast "+s,Toast.LENGTH_LONG).show()
        }
    }
}