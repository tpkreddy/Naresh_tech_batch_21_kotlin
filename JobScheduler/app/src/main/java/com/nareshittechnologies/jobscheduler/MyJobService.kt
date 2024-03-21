package com.nareshittechnologies.jobscheduler

import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.util.Log

class MyJobService:JobService() //TODO: Create a class and extend it to JobService(...)
{
    override fun onStartJob(params: JobParameters?): Boolean {
        // You can define your own task
        Log.d("MAIN","Conditions are met and your job is executed")
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("MAIN","Job is cancelled!")
        return false
    }

}