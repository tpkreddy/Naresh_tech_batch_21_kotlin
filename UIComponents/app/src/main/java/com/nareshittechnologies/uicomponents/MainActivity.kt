package com.nareshittechnologies.uicomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.textfield.TextInputLayout
import java.util.Objects

class MainActivity : AppCompatActivity(){
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
        val country:AppCompatSpinner = findViewById(R.id.spinner)
        val index:Int = country.selectedItemPosition
        val c =  country.adapter.getItem(index) as String

        val sc:SwitchCompat = findViewById(R.id.switch_tog)
        var rotationalShift = false
        if(sc.isChecked){
            rotationalShift = true
        }
        /*var c:String = ""
        country.setOnItemSelectedListener(object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                c = parent?.selectedItem as String
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        })*/
        val eng:CheckBox = findViewById(R.id.eng)
        val hin:CheckBox = findViewById(R.id.hin)
        val tam:CheckBox = findViewById(R.id.tam)

        var languages:String = ""
        if(eng.isChecked){
            languages = languages + "English\n"
        }
        if(hin.isChecked){
            languages = languages+"Hindi\n"
        }
        if(tam.isChecked){
            languages = languages + "Tamil\n"
        }
        var g:String = "Male"
        gender_group.setOnCheckedChangeListener { ge, c ->
            if(c == R.id.male){
                g = "Male"
            }else if(c == R.id.female){
                g = "Female"
            }
        }
        val name = pn.editText?.text.toString()
        val age = pa.editText?.text.toString().toInt()



        result.text = "$c $rotationalShift"

    }
}