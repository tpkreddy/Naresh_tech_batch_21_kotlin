package com.nareshittechnologies.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var jsonPlaceHolderService:JsonPlaceHolderService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO 1: Create a retrofit object
        val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // TODO 2: Create or initialize the JSonPlaceHolder service
        jsonPlaceHolderService = retrofit.create(JsonPlaceHolderService::class.java)
    }

    fun getData(view: View) {
        jsonPlaceHolderService?.getData()?.enqueue(object: Callback<FakeGet>{
            override fun onResponse(call: Call<FakeGet>, response: Response<FakeGet>) {
                val post = response.body()
                Toast.makeText(applicationContext,post?.body,Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<FakeGet>, t: Throwable) {
                Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
            }

        })
    }
    fun postData(view: View) {
        jsonPlaceHolderService?.postData(PostRequest("Pavan","Trainer",10))?.enqueue(object:Callback<PostResponse>{
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                Toast.makeText(applicationContext,response?.body().toString(),Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}
