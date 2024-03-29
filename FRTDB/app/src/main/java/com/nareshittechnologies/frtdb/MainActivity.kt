package com.nareshittechnologies.frtdb

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
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

        binding.progressBar.visibility = ProgressBar.INVISIBLE

        binding.saveBtn.setOnClickListener {
            // tODO write code to save data on to firebase real time databases
            binding.progressBar.visibility = ProgressBar.VISIBLE
            val name:String = binding.personName.text.toString()
            val age:Int = binding.personAge.text.toString().toInt()
            // I want to push each entry into a unique code.
            val p:PersonData = PersonData(name, age);
            // Now push this to frtdb
            reference.child("Person").push().setValue(p).addOnSuccessListener {v->
                Toast.makeText(applicationContext,"Data Published!", Toast.LENGTH_LONG).show()
                binding.progressBar.visibility = ProgressBar.INVISIBLE
                binding.personName.text.clear()
                binding.personAge.text.clear()
            }.addOnFailureListener {
                Toast.makeText(applicationContext,"Data not Published!", Toast.LENGTH_LONG).show()
                binding.progressBar.visibility = ProgressBar.INVISIBLE
            }
        }

        binding.loadBtn.setOnClickListener {
            // tODO: write code to load Data from FRTDB
            binding.progressBar.visibility = ProgressBar.VISIBLE
            val postListener:ValueEventListener = object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    // Actual logic of reading the data starts here
                    binding.progressBar.visibility = ProgressBar.INVISIBLE
                    binding.result.text = ""
                    for(s in snapshot.children){
                        val id:String? = s.key
                        val p:PersonData = s.getValue(PersonData::class.java) as PersonData
                        binding.result.append("${id}  ${p.name}  ${p.age}\n")
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    binding.progressBar.visibility = ProgressBar.INVISIBLE
                    Toast.makeText(applicationContext,"Data Not ready", Toast.LENGTH_LONG).show()
                }
            }

            reference.child("Person").addValueEventListener(postListener)
        }

        binding.updatebtn.setOnClickListener {
            // Update one value using the key
          /*  val p:PersonData = PersonData("TPKR", 32);
            reference.child("Person").child("-Nu9ebuqDj9x_TbYuyuW").setValue(p).addOnSuccessListener {
                Toast.makeText(applicationContext,"Updated",Toast.LENGTH_LONG).show()
            }*/
            reference.child("Person").child("-Nu4ghSGfOh9b5kiqA6-").removeValue().addOnSuccessListener {
                Toast.makeText(applicationContext,"Removed",Toast.LENGTH_LONG).show()
            }

        }
    }
}