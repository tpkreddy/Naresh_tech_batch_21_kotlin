package com.nareshittechnologies.uicomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // This function is called after filling the data on the other views and button is clicked.
    fun registerWithData(view: View) {

        val pn:TextInputLayout = findViewById(R.id.person_name)
        val pa:TextInputLayout = findViewById(R.id.person_age)
        val result:TextView = findViewById(R.id.result)
        val gender_group:RadioGroup = findViewById(R.id.gender_group)
        var g:String = "Male"
        gender_group.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.male){
                g = "Male"
            }else if(checkedId == R.id.female){
                g = "Female"
            }
        }

        val name = pn.editText?.text.toString()
        val age = pa.editText?.text.toString().toInt()

        result.text = "$name  $age $g"

    }
}