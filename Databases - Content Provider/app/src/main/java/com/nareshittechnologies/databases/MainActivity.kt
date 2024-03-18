package com.nareshittechnologies.databases

import android.content.ContentValues
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pn:EditText = findViewById(R.id.personname_et)
        val pa:EditText = findViewById(R.id.personage_et)
        val s:Button = findViewById(R.id.button3);
        val l:Button = findViewById(R.id.button4);
        val r:TextView = findViewById(R.id.textView)

        var helper:DatabaseHelper = DatabaseHelper(this)

        s.setOnClickListener {
            val name = pn.text.toString()
            val age:Int = pa.text.toString().toInt()
            // Logic for saving the data in the database
            val values:ContentValues = ContentValues()
            values.put(DatabaseHelper.COL_1, name)
            values.put(DatabaseHelper.COL_2, age)
            helper.insertData(values)
            //reset the form
            pn.text.clear()
            pa.text.clear()
            pn.clearFocus()
            pa.clearFocus()
        }

        l.setOnClickListener {
            val c:Cursor = helper.loadData()
            // ITs time to extract the data and display
            r.text = ""
            c.moveToFirst()
            do{
                val id1 = c.getInt(0)
                val n1 = c.getString(1)
                val a1 = c.getInt(2)
                r.append("${id1} ${n1} ${a1}\n")
            }while(c.moveToNext())

            c.close()
        }
    }

    // TODO 1: Create a class that extends to SQLiteOpenHelper
    /**
     * SQLiteOpenHelper works on top of SQLiteDatabase to do the query transactions easily.*/
    // TODO 2: Create constants for table name and the table rows.
    // TODO 3: In the onCreate(...) method of DatabaseHelper class, we shall add the create query and run it so that the
    //  table gets created.
    // TODO 4: Save the data into the database table
    // TODO 5: Load Data
}