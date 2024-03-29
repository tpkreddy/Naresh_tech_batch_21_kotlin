package com.nareshittechnologies.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PersonTable::class], version = 1, exportSchema = true)
abstract class PersonDatabase3: RoomDatabase() {
    abstract fun personDao():PersonDAO
}