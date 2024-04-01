package com.nareshittechnologies.cx

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nareshittechnologies.cx.databinding.ActivityMainBinding
import com.nareshittechnologies.cx.databinding.ActivityUploadBinding

class UploadActivity : AppCompatActivity() {

    lateinit var activityUploadBinding:ActivityUploadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityUploadBinding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(activityUploadBinding.root)
        val photoURI = intent.getStringExtra("PHOTO")
        activityUploadBinding.imageView.setImageURI(photoURI?.toUri())
    }
}