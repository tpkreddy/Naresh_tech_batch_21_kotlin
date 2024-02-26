package com.nareshittechnologies.myfavoritemovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val i:Intent = intent
        val d = i.getSerializableExtra("DATA") as FavMovies
        val iv:ImageView = findViewById(R.id.details_poster)
        iv.setImageResource(d.poster)
    }
}