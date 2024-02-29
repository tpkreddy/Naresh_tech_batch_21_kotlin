package com.nareshittechnologies.jokesonly

import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import android.widget.Toast
import java.io.InputStream
import java.lang.StringBuilder
import java.net.URL
import java.net.URLConnection
import java.util.Scanner


class FetchJoke(val context:Context, val tv:TextView): AsyncTask<String, Void, String>() {

    override fun doInBackground(vararg params: String?): String {
        val url:URL = URL(params[0])
        //Establish a connection
        val connection:URLConnection = url.openConnection()
        // Read the data
        val ips:InputStream = connection.getInputStream()
        val builder:StringBuilder = StringBuilder()
        val s:Scanner = Scanner(ips)
        while (s.hasNext()){
            builder.append(s.nextLine())
        }
        return builder.toString()
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        tv.text = result
    }
}