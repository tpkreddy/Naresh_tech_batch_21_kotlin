package com.nareshittechnologies.executorsfornetworking

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import java.io.InputStream
import java.net.URL
import java.net.URLConnection
import java.util.Scanner
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun fetchData(view: View) {
        val executor = Executors.newSingleThreadExecutor()
        executor.execute {
            Runnable {
                val u:URL = URL("https://www.googleapis.com/books/v1/volumes?q=android")
                //Establish a connection
                val connection: URLConnection = u.openConnection()
                // Read the data
                val ips: InputStream = connection.getInputStream()
                val builder:StringBuilder = StringBuilder()
                val s: Scanner = Scanner(ips)
                while (s.hasNext()){
                    builder.append(s.nextLine())
                }
                Log.d("MAIN", builder.toString())
                runOnUiThread {
                    Toast.makeText(applicationContext,builder.toString(),Toast.LENGTH_LONG).show()
                }
        } }

    }
}