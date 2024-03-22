package com.nareshittechnologies.trackscoremvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nareshittechnologies.trackscoremvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityBinding:ActivityMainBinding

    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityBinding.root
        setContentView(view)

        activityBinding.plusbutton.setOnClickListener {
            count++
            activityBinding.result.text = "$count"
        }

        activityBinding.minusbutton.setOnClickListener {
            count--
            activityBinding.result.text = "$count"
        }
    }
}