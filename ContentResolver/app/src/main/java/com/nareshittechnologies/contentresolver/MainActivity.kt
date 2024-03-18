package com.nareshittechnologies.contentresolver

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object{
        val TABLE_NAME:String = "person"
        val COL_0:String = "person_id"
        val COL_1:String = "person_name"
        val COL_2:String = "person_age"
    }

    lateinit var tv:TextView;

    val AUTHORITY = "content://com.nareshittechnologies.databases.CONTENT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textview);

        val uri = Uri.parse(AUTHORITY)

        tv.text = ""

        val c:Cursor? = contentResolver.query(uri,null,null,null,null)

        c?.moveToFirst()
        do{
            val id1 = c?.getInt(0)
            val n1 = c?.getString(1)
            val a1 = c?.getInt(2)
            tv.append("${id1} ${n1} ${a1}\n")
        }while(c?.moveToNext() == true)

        c?.close()
    }
}