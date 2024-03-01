package com.nareshittechnologies.jokesonly

import android.content.DialogInterface
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.getSystemService
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab:FloatingActionButton = findViewById(R.id.floatingActionButton)
        val tv:TextView = findViewById(R.id.joke_here)
        val pb:ProgressBar = findViewById(R.id.progressBar)
        val imv:ImageView = findViewById(R.id.imageView)

        Glide.with(this)
            .load("https://play-lh.googleusercontent.com/zp9s9mkvcK3rkl9cgcGdC3oAfo53-SCshBOYUytdrTMy6Vtpht16l6yA9jZOHt5-ip4")
            .into(imv)

        pb.visibility = View.INVISIBLE

        fab.setOnClickListener{
            // Trigger the task
            val manager:ConnectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeConnection:NetworkInfo? = manager.activeNetworkInfo
            val isConnected:Boolean = (activeConnection!=null && activeConnection.isConnectedOrConnecting())
            if(isConnected){
                tv.text = ""
                pb.visibility = View.VISIBLE
                val joke:FetchJoke = FetchJoke(this, tv,pb)
                joke.execute("https://api.chucknorris.io/jokes/random")
                /*joke.execute("https://www.googleapis.com/books/v1/volumes?q=android")*/
            }else{
                /*Toast.makeText(this,"Make sure you have active connection",Toast.LENGTH_LONG).show()*/
                AlertDialog.Builder(this)
                    .setTitle("No Internet Connection")
                    .setMessage("Make sure you have a proper internet connection")
                    .setPositiveButton("OK", DialogInterface.OnClickListener(){
                        dialog, which ->
                        dialog.dismiss()
                    })
                    .setNeutralButton("I'm Neutral",null)
                    .setNegativeButton("Cancel",DialogInterface.OnClickListener(){
                        dialog, which ->
                        dialog.dismiss()
                    })
                    .show()
            }

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
