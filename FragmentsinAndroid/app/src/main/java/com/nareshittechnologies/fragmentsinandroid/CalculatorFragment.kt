package com.nareshittechnologies.fragmentsinandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class CalculatorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_calculator, container, false)

        val r:TextView = v.findViewById(R.id.result)
        (v.findViewById<Button>(R.id.plus)).setOnClickListener {
            val a:Int =(v.findViewById<EditText>(R.id.num1)).text.toString().toInt()
            val b:Int = (v.findViewById<EditText>(R.id.num2)).text.toString().toInt()
            r.text = "${a+b}"
        }
        (v.findViewById<Button>(R.id.minus)).setOnClickListener {
            val a:Int =(v.findViewById<EditText>(R.id.num1)).text.toString().toInt()
            val b:Int = (v.findViewById<EditText>(R.id.num2)).text.toString().toInt()
            r.text = "${a-b}"
        }
        (v.findViewById<Button>(R.id.prod)).setOnClickListener {
            val a:Int =(v.findViewById<EditText>(R.id.num1)).text.toString().toInt()
            val b:Int = (v.findViewById<EditText>(R.id.num2)).text.toString().toInt()
            r.text = "${a*b}"
        }
        (v.findViewById<Button>(R.id.divi)).setOnClickListener {
            val a:Int =(v.findViewById<EditText>(R.id.num1)).text.toString().toInt()
            val b:Int = (v.findViewById<EditText>(R.id.num2)).text.toString().toInt()
            r.text = "${a/b}"
        }

        return v
    }
}