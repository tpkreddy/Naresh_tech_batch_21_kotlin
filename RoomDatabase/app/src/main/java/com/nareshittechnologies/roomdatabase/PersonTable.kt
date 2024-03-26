package com.nareshittechnologies.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
class PersonTable(person_name: String?, person_age: Int) {
    @PrimaryKey(autoGenerate = true)
    var person_id: Int = 0
    @ColumnInfo(name = "personname")
    var person_name: String?=person_name
    var person_age: Int = person_age

}

