package com.nareshittechnologies.co_routines
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nareshittechnologies.co_routines.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.net.URL
import java.util.Scanner
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {
    val fetchJokes = "https://api.chucknorris.io/jokes/random"
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var scope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        // Set up CoroutineScope
        scope = CoroutineScope(Dispatchers.Main)

        activityMainBinding.progressBar.visibility = ProgressBar.INVISIBLE
        activityMainBinding.button.setOnClickListener {
            fetchData()
        }
    }

    private fun fetchData() {
        activityMainBinding.progressBar.visibility = ProgressBar.VISIBLE
        scope.launch {
            val data = fetchDataAsync() // Create a new Deferred object each time fetchData is called
            try {
                val d = data.await()
                activityMainBinding.result.text = d
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Error fetching data", Toast.LENGTH_SHORT).show()
            } finally {
                activityMainBinding.progressBar.visibility = ProgressBar.INVISIBLE
            }
        }
    }

    private suspend fun fetchDataAsync(): Deferred<String> = scope.async(Dispatchers.IO) {
        val url = URL(fetchJokes)
        val connection = url.openConnection() as HttpsURLConnection
        val inputStream = connection.inputStream
        val scanner = Scanner(inputStream)
        val stringBuilder = StringBuilder()
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine())
        }
        stringBuilder.toString()
    }
}
