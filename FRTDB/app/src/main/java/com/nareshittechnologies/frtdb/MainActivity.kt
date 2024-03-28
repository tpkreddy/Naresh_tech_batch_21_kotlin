package com.nareshittechnologies.frtdb

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import com.nareshittechnologies.frtdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var reference:DatabaseReference
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Intialize the reference
        reference = Firebase.database.reference

        binding.saveBtn.setOnClickListener {
            // tODO write code to save data on to firebase real time databases
            val name:String = binding.personName.text.toString()
            val age:Int = binding.personAge.text.toString().toInt()
            // I want to push each entry into a unique code.
            val p:PersonData = PersonData(name, age);
            // Now push this to frtdb
            reference.child("Person").push().setValue(p)
        }

        binding.loadBtn.setOnClickListener {
            // tODO: write code to load Data from FRTDB
        }

    }
}