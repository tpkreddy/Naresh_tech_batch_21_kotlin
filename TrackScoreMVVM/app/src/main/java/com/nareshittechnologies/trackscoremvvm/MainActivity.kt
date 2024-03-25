package com.nareshittechnologies.trackscoremvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.nareshittechnologies.trackscoremvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityBinding:ActivityMainBinding

    var count = 0
    var mvm:MainViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityBinding.root
        setContentView(view)

        /*ViewModelProviders offers the management of ViewModel across the configuration change of this activity*/
        mvm = ViewModelProvider(this).get(MainViewModel::class.java)
        /*Actual business logic is around the variable called Count*/

        activityBinding.result.text = "${mvm!!.count.value}"

        mvm!!.count.observe(this,  {t->
           activityBinding.result.text = t.toString()
        })

        activityBinding.plusbutton.setOnClickListener {
            mvm!!.incrementCount()
        }

        activityBinding.minusbutton.setOnClickListener {
            mvm!!.decrementCount()
        }
    }
}