package com.nareshittechnologies.jobscheduler

import android.app.job.JobInfo
import android.app.job.JobInfo.NETWORK_TYPE_ANY
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var scheduler: JobScheduler
    lateinit var jobInfo: JobInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler

        // tODO : Time to set the conditions for our JObScheduler
        jobInfo = JobInfo.Builder(21, ComponentName(this,MyJobService::class.java))
            .setRequiredNetworkType(NETWORK_TYPE_ANY)
            .build()
    }

    fun scheduleJob(view: View) {
        scheduler.schedule(jobInfo)
    }
}