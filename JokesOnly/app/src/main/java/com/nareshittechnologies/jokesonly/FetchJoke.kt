package com.nareshittechnologies.jokesonly

import android.content.Context
import android.os.AsyncTask
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.lang.StringBuilder
import java.net.URL
import java.net.URLConnection
import java.util.Scanner


class FetchJoke(val context:Context, val tv:TextView, val pb:ProgressBar): AsyncTask<String, Void, String>() {

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
        // TODO: Parse the JSON Data and only display what is needed.
        val obj:JSONObject = JSONObject(result)
        val joke:String = obj.getString("value")
        pb.visibility = View.INVISIBLE
        tv.text = joke
      /*  val obj:JSONObject = JSONObject(result)
        val arr:JSONArray = obj.getJSONArray("items")
        tv.text = ""
        var i = 0
        while (i<arr.length()){
            val item = arr.getJSONObject(i)
            val volInfo = item.getJSONObject("volumeInfo")
            val title = volInfo.getString("title")
            tv.append("$title\n")
            i++
        }*/
    }
}