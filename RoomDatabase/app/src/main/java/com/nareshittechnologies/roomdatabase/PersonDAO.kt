package com.nareshittechnologies.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PersonDAO {

    @Insert
    fun insertData(p:PersonTable):Unit

    @Query("select * from person")
    fun getAll():List<PersonTable>

    @Update
    fun updateData(p:PersonTable):Unit
}