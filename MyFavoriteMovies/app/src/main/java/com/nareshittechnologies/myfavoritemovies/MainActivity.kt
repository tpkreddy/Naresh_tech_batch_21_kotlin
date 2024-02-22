package com.nareshittechnologies.myfavoritemovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    // TODO 1: Prepare Data
    // create a data class for the fav movies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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