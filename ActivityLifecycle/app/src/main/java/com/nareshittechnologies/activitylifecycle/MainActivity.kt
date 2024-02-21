package com.nareshittechnologies.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MAIN","onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MAIN","onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MAIN","onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MAIN","onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MAIN","onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MAIN","onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MAIN","onRestart()")
    }
}