package com.nareshittechnologies.myfavoritemovies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nareshittechnologies.myfavoritemovies.MoviesAdapter.MoviesViewHolder

class MoviesAdapter(val context: Context, val movies:List<FavMovies>):Adapter<MoviesViewHolder>(){

    class MoviesViewHolder(val v:View):ViewHolder(v){
        val imageView:ImageView = v.findViewById(R.id.movie_poster)
        val movie_name:TextView = v.findViewById(R.id.movie_name)
        val actors:TextView = v.findViewById(R.id.actors_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val v:View = LayoutInflater.from(context).inflate(R.layout.one_item_design,parent,false)
        return MoviesViewHolder(v)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.imageView.setImageResource(movies.get(position).poster)
        holder.movie_name.text = movies.get(position).movie
        var s:String = ""
        for(i in movies.get(position).actors){
            s += "$i\n"
        }
        holder.actors.text = s
    }
}

/**
 * Why do you need an adapter ?
 * When you have a lot of items to display on a single view, you need an adapter.
 *
 * The RecyclerView.Adapter<VH> needs ViewHolder(VH) information.
 * Adapter needs it because, we want to show the data in the design style we want and your RecyclerView.ViewHolder class
 * has that information.
 *
 * There are three methods that we need to override
 * - onCreateViewHolder(...): ViewHolder
 *      - it attaches (inflates) the design that we created (one_item_design.xml) to all the items of the recyclerView
 * - onBindViewHolder(...):Unit
 *      - Based on the position of the item, this method populates data on the item of the recyclerview.
 * - getItemCount(...)
 *      - Will tell the recyclerview about how many items does it have
 * What kind of code will you write in ViewHolder ?
 * we write the connection of various views that we have to appropriate objects, so that these objects can be
 * used by onBindViewHolder(...) method to populate data.
 * */