package com.nareshittechnologies.listviewandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity()/*,OnItemClickListener*/ {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lv:ListView = findViewById(R.id.listview)

        // To display the items on listview dynamically
        val fruits = arrayOf("Apple","Banana","Guava","Grapes","Mosambi","Oranges","Kiwi","Dragon","Apricot","Mango","Water melon")
        val adapter:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,fruits)
        lv.adapter = adapter
        lv.setOnItemClickListener { parent, view, position, id ->
            var fruit = parent.getItemAtPosition(position).toString()
            Toast.makeText(this,"$fruit",Toast.LENGTH_LONG).show()
        }

        /*lv.setOnItemClickListener(this)*/

        /*lv.setOnItemClickListener(object:OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var fruit = parent?.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext,"$fruit",Toast.LENGTH_LONG).show()
            }
        })*/
    }

    /*override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var fruit = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this,"$fruit",Toast.LENGTH_LONG).show()
    }*/
}