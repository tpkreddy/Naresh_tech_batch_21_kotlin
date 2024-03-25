package com.nareshittechnologies.roomdatabase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nareshittechnologies.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   lateinit var activityMainBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val v = activityMainBinding.root
        setContentView(v)
    }
}