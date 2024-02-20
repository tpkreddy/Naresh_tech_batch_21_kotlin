package com.nareshittechnologies.commonintents

import android.content.ContentResolver
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.Image
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.google.android.material.textfield.TextInputLayout
import java.io.File
import java.io.IOException
import java.net.URI
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var imageURI: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openMaps(view: View) {
        // We need to use implicit intnet
        // Step 1: Define the action
        // Step 2: Supply data for the aforementioned action in a certain style (Data Scheme)
        val address = (findViewById<TextInputLayout>(R.id.address)).editText?.text.toString()
        val scheme = Uri.parse("geo:0,0?q=${address}")
        // Step 3: Create an intent with both these arguments
        val i = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=${address}"))
        startActivity(i);
        // Step 4: Sttart the Activity
        startActivity(i)
    }

    fun openBrowser(view: View) {
        // We need to use implicit intnet
        // Step 1: Define the action
        // Step 2: Supply data for the aforementioned action in a certain style (Data Scheme)
        val address = (findViewById<TextInputLayout>(R.id.url_to_open)).editText?.text.toString()
        val scheme = Uri.parse("https://${address}")
        // Step 3: Create an intent with both these arguments
        val i = Intent(Intent.ACTION_VIEW, scheme)
        startActivity(i);
        // Step 4: Sttart the Activity
        startActivity(i)
    }

}