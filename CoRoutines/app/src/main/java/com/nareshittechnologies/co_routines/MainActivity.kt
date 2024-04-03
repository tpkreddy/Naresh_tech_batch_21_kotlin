package com.nareshittechnologies.co_routines

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nareshittechnologies.co_routines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import java.util.Scanner
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {
    val fetchJokes = "https://api.chucknorris.io/jokes/random"
    lateinit var activityMainBinding:ActivityMainBinding
    lateinit var scope:CoroutineScope
    lateinit var data:Deferred<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        // tODO 1: Define the scope of your coroutine
        /*I want to do network operation such as getting the data from internet.
        * Hence, the thread on which i can run my coroutine should be IO thread.*/
        scope = CoroutineScope(Dispatchers.IO)

        // TODO 2: set up the asynchronous request
        /*We are expecting a return result from the coroutine that we want to start - Which launcher suits here
        * async*/
        data = scope.async {
            // Logic to fetch data from internet
           val url = URL(fetchJokes)
           val connection = url.openConnection() as HttpsURLConnection
           val ips = connection.inputStream
           val s:Scanner = Scanner(ips)
           var line:String = ""
           var sb = StringBuilder()
           do{
               line = s.nextLine()
               sb.append(line)
           }while(s.hasNext())
            sb.toString()
        }

        activityMainBinding.progressBar.visibility = ProgressBar.INVISIBLE
        activityMainBinding.button.setOnClickListener {
            fetchData()
        }
    }

    private fun fetchData() {
        activityMainBinding.progressBar.visibility = ProgressBar.VISIBLE
        scope.launch {
            val d = data.await()
            // tODO 3: Switch the thread of your coroutine from IO to main to update the UI
            withContext(Dispatchers.Main){
                activityMainBinding.result.text = ""
                activityMainBinding.result.text = d
                activityMainBinding.progressBar.visibility = ProgressBar.INVISIBLE
            }
        }
    }
}