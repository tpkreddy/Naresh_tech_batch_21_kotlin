package com.nareshittechnologies.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class PersonTable(
    @PrimaryKey(autoGenerate = true) val person_id:Int,
    @ColumnInfo(name = "personname") val person_name:String,
    val person_age:Int
)

