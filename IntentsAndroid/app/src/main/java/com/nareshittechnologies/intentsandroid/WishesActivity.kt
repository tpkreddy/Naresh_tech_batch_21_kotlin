package com.nareshittechnologies.intentsandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WishesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishes)

        // Step 4: Get the data sent from the previous activity (MainActivity)
        val d = intent.extras?.getString("NAME")
        // Step 5: Display the d on the text view
        findViewById<TextView>(R.id.bdayname).text = d
    }
}