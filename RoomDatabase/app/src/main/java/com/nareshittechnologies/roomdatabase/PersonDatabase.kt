package com.nareshittechnologies.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PersonTable::class], version = 1, exportSchema = true)
abstract class PersonDatabase: RoomDatabase() {
    abstract fun personDao():PersonDAO
}