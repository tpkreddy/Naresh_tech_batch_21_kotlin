package com.nareshittechnologies.myfavoritemovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    // TODO 1: Prepare Data
    // create a data class for the fav movies
    // TODO 2: Create a layout - for designing how you want each item on the recyclerview to be displayed
    // TODO 3: Add a recyclerView in the project (first in the activity_main.xml and then in .kt file)
    // TODO 4: create a RecyclerView Adapter that takes in Recyclerview viewholder
    // TODO 5: Create an Adapter (a) Object and set it to recyclerView Object (rv)
    // TODO 6: set up the layout manager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv:RecyclerView = findViewById(R.id.recyclerview)
        val a:MoviesAdapter = MoviesAdapter(this,prepareData())
        rv.adapter = a
        /*rv.layoutManager = LinearLayoutManager(this)*/
        rv.layoutManager = GridLayoutManager(this,2)
    }

    fun prepareData():List<FavMovies>{
        return mutableListOf(FavMovies(R.drawable.a,"Animal", listOf("Ranbir","Rashmika")),
            FavMovies(R.drawable.b,"Baazigar", listOf("Sharukh khan","Kajol")),
            FavMovies(R.drawable.c,"Chak de India", listOf("Sharukh Khan")),
            FavMovies(R.drawable.d,"Don", listOf("Amitabh","Zeenat Aman", "Pran")),
            FavMovies(R.drawable.e,"Ek Villain", listOf("Siddharth Malhotra","Shraddha Kapoor")),
            FavMovies(R.drawable.f,"Fukrey", listOf("Varun Sharma","Pulkit Samrat")),
            FavMovies(R.drawable.g,"Gadar", listOf("Sunny deol","Amisha Patel")),
            FavMovies(R.drawable.h,"Hanu Man", listOf("Teja Sajja","Amritha Nair")),
            FavMovies(R.drawable.i,"I", listOf("Vikram","Amy Jackson")),
            FavMovies(R.drawable.j,"Jackpot", listOf("Naseeruddin Shah","Sunny Leone")))
    }
}