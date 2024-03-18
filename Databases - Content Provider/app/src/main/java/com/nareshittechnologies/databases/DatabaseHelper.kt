package com.nareshittechnologies.databases

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(val context:Context):SQLiteOpenHelper(context,"pavan.db",null,1) {

    companion object{
        val TABLE_NAME:String = "person"
        val COL_0:String = "person_id"
        val COL_1:String = "person_name"
        val COL_2:String = "person_age"
    }

    // This method helps us to create the database tables
    override fun onCreate(db: SQLiteDatabase?) {
        val query:String = "CREATE TABLE ${DatabaseHelper.TABLE_NAME}(${DatabaseHelper.COL_0} integer primary key autoincrement, ${DatabaseHelper.COL_1} text, ${DatabaseHelper.COL_2} integer);"
        db?.execSQL(query)
    }

    // This method is used when there is upgrade to the already existing database tables.
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("Drop table ${DatabaseHelper.TABLE_NAME}")
        onCreate(db)
    }

    fun insertData(values:ContentValues){
        // You need an SQLiteDatabase object with write permissions
        val db:SQLiteDatabase  = this.writableDatabase
        db.insert(DatabaseHelper.TABLE_NAME,null,values)
    }

    fun loadData():Cursor{
        val db:SQLiteDatabase = this.readableDatabase
        return db.rawQuery("select * from ${DatabaseHelper.TABLE_NAME}",null,null)
    }
}