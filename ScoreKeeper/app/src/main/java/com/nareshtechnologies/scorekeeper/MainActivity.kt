package com.nareshtechnologies.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textView:TextView
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This is the first method, that gets invoked as soon as an activity (screen) is created.
        textView = findViewById(R.id.result)
    }

    // This function gets invoked as soon as the button (+) gets clicked.
    fun incrementScore(view: View) {
        count++
        textView.setText(count.toString())
    }

    // This function gets invoked as soon as the button (-) gets clicked.
    fun decrementScore(view: View) {
        count--
        textView.setText(count.toString())
    }
}