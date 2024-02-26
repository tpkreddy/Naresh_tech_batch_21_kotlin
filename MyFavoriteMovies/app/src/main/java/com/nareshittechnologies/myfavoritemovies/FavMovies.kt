package com.nareshittechnologies.myfavoritemovies

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class FavMovies(val poster:Int, val movie:String, val actors:List<String>):Serializable
