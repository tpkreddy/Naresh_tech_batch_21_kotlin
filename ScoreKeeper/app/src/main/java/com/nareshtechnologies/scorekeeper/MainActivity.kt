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

        if(savedInstanceState!=null && savedInstanceState.containsKey("COUNT")){
            count = savedInstanceState.getInt("COUNT")
            textView.text = count.toString()
        }
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

    // Whenever you want to save the count value during the configuration change of an Activity (Portrait to landscape and vice versa_
    // use the onSaveInstanceState() method.

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // What ever the values you want to save must be saved to the outState bundle object along with a key.
        outState.putInt("COUNT",count)
    }
}