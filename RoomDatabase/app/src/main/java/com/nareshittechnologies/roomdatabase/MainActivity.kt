package com.nareshittechnologies.roomdatabase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.nareshittechnologies.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   lateinit var activityMainBinding:ActivityMainBinding
   lateinit var room:PersonDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val v = activityMainBinding.root
        setContentView(v)

        // Initializing the Room database object
        room = Room.databaseBuilder(applicationContext,PersonDatabase::class.java,"pavan.db")
            .allowMainThreadQueries()
            .build()

        activityMainBinding.saveBtn.setOnClickListener {
            // Save the data to the database
            val name:String = activityMainBinding.personName.text.toString()
            val age:Int = activityMainBinding.personAge.text.toString().toInt()
            // Prepare the dataclass object
            val p:PersonTable = PersonTable(name,age)

            room.personDao().insertData(p)

            Snackbar.make(it,"Success",Snackbar.LENGTH_LONG).show()
        }

        activityMainBinding.loadBtn.setOnClickListener {
            // load the data from the database
            val persons = room.personDao().getAll()
            activityMainBinding.result.text = ""
            for(i in persons){
                activityMainBinding.result.append("${i.person_id} ${i.person_name} ${i.person_age}\n")
            }
        }
    }
}