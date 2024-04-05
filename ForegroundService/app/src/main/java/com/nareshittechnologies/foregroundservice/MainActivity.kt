package com.nareshittechnologies.foregroundservice

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if(checkCallingOrSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS)!=PackageManager.PERMISSION_GRANTED){
                requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),0)
            }
        }

    }

    fun startMyForeground(view: View) {
        val i = Intent(this, MyForegroundService::class.java)
        startForegroundService(i)
    }

    fun stop2Service(view: View) {
        val i = Intent(this, MyForegroundService::class.java).setAction("MYACTION")
        startService(i)
    }
}