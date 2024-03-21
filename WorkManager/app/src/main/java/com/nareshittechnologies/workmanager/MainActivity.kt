package com.nareshittechnologies.workmanager

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun startMyWork(view: View) {
        // One - Time Request
        // PeriodicWorkRequest
        // Just like the jobscheduler, you will need to set up the conditions. We call them as "constraints"
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()

        // You can schedule the task
        val oneTimeWorkRequest:OneTimeWorkRequest = OneTimeWorkRequestBuilder<MyWork>()
            .setConstraints(constraints)
            .build()

        // Set Periodic work request (this repeats continuosly based on the time)
        val periodic = PeriodicWorkRequestBuilder<MyWork>(15, TimeUnit.MINUTES, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS, TimeUnit.MILLISECONDS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueue(periodic)
    }
}