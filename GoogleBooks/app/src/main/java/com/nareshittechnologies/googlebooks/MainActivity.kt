package com.nareshittechnologies.googlebooks

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.Gson
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val til:TextInputLayout = findViewById(R.id.editText)
        val ib:ImageButton = findViewById(R.id.imageButton)
        val pb:ProgressBar = findViewById(R.id.progressBar)
        var link:String = "https://www.googleapis.com/books/v1/volumes?q="
        pb.visibility = View.INVISIBLE
        ib.setOnClickListener { v->
            // Prepare the url
            val s:String = til.editText?.text.toString()
            link = link+"$s"
            pb.visibility = View.VISIBLE
            // Volley Networking
            doNetworkRequest(link,pb)
        }
    }

    private fun doNetworkRequest(link: String, pb: ProgressBar) {
        val queue:RequestQueue = Volley.newRequestQueue(this)

        val stringRequest:StringRequest = StringRequest(Request.Method.GET, link,Response.Listener { response ->
            pb.visibility = ProgressBar.INVISIBLE
            val g:Gson = Gson()
            val sd:SourceData = g.fromJson(response,SourceData::class.java)
            val rv:RecyclerView = findViewById(R.id.recyclerview)
            val adapter:BooksAdapter = BooksAdapter(applicationContext,sd.items)
            rv.adapter = adapter
            rv.layoutManager = LinearLayoutManager(this)

        }, Response.ErrorListener { error ->
            // Implementation goes here

        })

        queue.add(stringRequest)
    }

    class BooksAdapter(val context: Context, val items:List<Items>):Adapter<BooksAdapter.BooksViewHolder>(){

        class BooksViewHolder(v:View):ViewHolder(v){
            val iv:ImageView = v.findViewById(R.id.book_thumbnail)
            val title:TextView = v.findViewById(R.id.book_title)
            val authors:TextView = v.findViewById(R.id.book_authors)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
            return BooksViewHolder(LayoutInflater.from(context).inflate(R.layout.one_book_detail,parent,false))
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
            Glide.with(context)
                .load(items.get(position).volumeInfo?.imageLinks?.thumbnail)
                .into(holder.iv)

            holder.title.text = items.get(position).volumeInfo?.title

            holder.authors.text = items.get(position).volumeInfo?.authors?.get(0)

        }
    }
}