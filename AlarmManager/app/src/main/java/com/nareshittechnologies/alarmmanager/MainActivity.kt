package com.nareshittechnologies.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // TODO 3: Create AlarmManager and PendingIntent
    lateinit var alarm:AlarmManager
    lateinit var pi:PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alarm = getSystemService(ALARM_SERVICE) as AlarmManager
        pi = PendingIntent.getBroadcast(this, 12, Intent(this, HydrationReceiver::class.java), PendingIntent.FLAG_UPDATE_CURRENT)

    }

    fun startRemainder(view: View) {
        // TODO 4: I want an alarm to remaind the user to have a glass of water every 2 minutes.
            // TODO 4.1 : Set the alarm type
            val alarmType = AlarmManager.ELAPSED_REALTIME
            // TODO 4.2: define when do you want to get your first alarm
            val firstTriggerTime = SystemClock.elapsedRealtime()
            // TODO 4.3: what is the interval time.
            val intervalTime:Long = 2*60*1000
            // TODO 4.4: set the alarm
            alarm.setInexactRepeating(alarmType,firstTriggerTime,intervalTime,pi)
    }

    fun stopRemainder(view: View) {
        alarm.cancel(pi)
    }
}