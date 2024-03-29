package com.nareshittechnologies.roomdatabase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var b1:Button
    lateinit var b2:Button
    lateinit var e1:EditText
    lateinit var e2:EditText
    lateinit var tv:TextView
   lateinit var room:PersonDatabase3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the Room database object
        room = Room.databaseBuilder(applicationContext,PersonDatabase3::class.java,"Pavan.db")
            .allowMainThreadQueries()
            .build()

        b1 = findViewById(R.id.save_btn)
        b2 = findViewById(R.id.load_btn)
        e1 = findViewById(R.id.person_name)
        e2 = findViewById(R.id.person_age)
        tv = findViewById(R.id.result)

        b1.setOnClickListener {
            // Save the data to the database
            val name:String = e1.text.toString()
            val age:Int = e2.text.toString().toInt()
            // Prepare the dataclass object
            val p:PersonTable = PersonTable(name,age)

            room.personDao().insertData(p)

            Snackbar.make(it,"Success",Snackbar.LENGTH_LONG).show()
        }

        b2.setOnClickListener {
            // load the data from the database
            val persons = room.personDao().getAll()
            tv.text = ""
            for(i in persons){
                tv.append("${i.person_id} ${i.person_name} ${i.person_age}\n")
            }
        }
    }
}