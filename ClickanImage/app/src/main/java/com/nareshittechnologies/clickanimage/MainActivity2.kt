package com.nareshittechnologies.clickanimage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nareshittechnologies.clickanimage.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var activityMain2Binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMain2Binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(activityMain2Binding.root)
        val s:String? = intent.getStringExtra("IMAGE")
        activityMain2Binding.imageView.setImageURI(s?.toUri())
    }
}