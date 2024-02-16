package com.nareshittechnologies.intentsandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b:Button = findViewById(R.id.button)

        b.setOnClickListener { v ->
            // From here I want to move to the next screen (WishesAcitivity)
            // Step  1: Create an Intent Object
            val i : Intent = Intent(this,WishesActivity::class.java)
            // Step 2: get the data from edit text box
            val name = findViewById<EditText>(R.id.person_name).text.toString()
            // Step 3: add this name as an extra value for the intent object
            i.putExtra("NAME",name)
            startActivity(i)
        }
    }
}