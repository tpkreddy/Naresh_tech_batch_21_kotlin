package com.nareshittechnologies.jokesonly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab:FloatingActionButton = findViewById(R.id.floatingActionButton)
        val tv:TextView = findViewById(R.id.joke_here)
        fab.setOnClickListener{
            // Trigger the task
            val joke:FetchJoke = FetchJoke(this, tv)
            joke.execute("https://api.chucknorris.io/jokes/random")
        }

    }
}

    // TODO 1: Whenever you use Internet, it is mandatory to declare the permission in the manifest.
    //  This permission doesnot require the user's Approval.
    // TODO 2: Prepare your UI
    // TODO 3: When the button is clicked, fetch the joke from the url,
    //  read the contents and display the contents on the textview.
    // TODO 4: Create a class and extend it to AsyncTask<DataTypeForSendingData, DataTypeForRecevingProgress, DataTypeForResults>
    //  Now, Override the default methods (doInBackground() and onPostExeute().
    // todo 5: trigger the task
